(ns clj_skroutz.core
  (require [clj-http.client :as client])
  (require [cheshire.core :as json])
  (require [cemerick.url :as url])
  (require [carica.core :as carica]))

(def ^:dynamic defaults {:oauth_token (carica/config :app-token)})

(defn format-url
  ([end-point]
    (format-url end-point ""))
  ([end-point positional]
    (let [url (carica/config :url)]
      (str url (apply format end-point positional)))))

(defn update-req
  "Given a clj-http request, and a 'next' url string, merge the next url into the request"
  [req url]
  (let [url-map (url/url url)]
    (assoc-in req [:query-params] (-> url-map :query))))

(defn build-request
  "Builds a request to Skroutz API using some sane defaults."
  [method end-point positional
   {:strs [throw_exceptions follow_redirects accept
           oauth_token user_agent auth-prefix]
    :or {follow_redirects true, throw_exceptions false,
         accept (carica/config :accept-header),
         user_agent (carica/config :user-agent)
         auth-prefix (carica/config :auth-prefix)}
    :as query}]
  (let [req (merge-with merge
                        {:url (format-url end-point positional)
                         :throw-exceptions throw_exceptions
                         :follow-redirects follow_redirects
                         :method method}
                        (when accept
                          {:headers {"Accept" accept}})
                        (when oauth_token
                          {:headers {"Authorization" (str auth-prefix oauth_token)}})
                        (when user_agent
                          {:headers {"User-Agent" user_agent}})
                        )]
  req))

(defn parse-links
  [links]
  [])

(defn extract-useful-meta
  [req]
  [])

(defn query-map
  "Merge defaults, turn keywords into strings, and replace hyphens with
   underscores."
  [entries]
  (into {}
        (for [[k v] (concat defaults entries)]
          [(.replace (name k) "-" "_") v])))

(defn api-response
  "Takes a response and checks for certain status codes. If 204, return nil.
   If 400, 401, 204, 422, 403, 404 or 500, return the original response with the
   body parsed as json. Otherwise, parse and return the body if json, or return
   the body if raw."
  [{:keys [headers status body] :as resp}]
  (cond
    (= 204 status)
    nil
    (= 304 status)
    nil
    (#{400 401 403 404 422 500} status)
    resp
    :else (let [links (parse-links (get headers "link" ""))
               content-type (get headers "content-type")
               metadata (extract-useful-meta headers)]
           (if-not (.contains content-type "raw")
             (let [parsed (json/parse-string body)]
               (if (map? parsed)
                 (with-meta parsed {:links links :api-meta metadata})
                 (with-meta (map #(with-meta % metadata) parsed)
                   {:links links :api-meta metadata})))
             body))))

(defn api-call
  ([method end-point] (api-call method end-point nil nil))
  ([method end-point positional] (api-call method end-point positional nil))
  ([method end-point positional query]
    (let [query (query-map query)
          all-pages? (query "all_pages")
          req (build-request method end-point positional query)
          exec-request-one (fn exec-request-one [req]
                              (api-response (client/request req)))
          exec-request (fn exec-request [req]
                          (let [resp (exec-request-one req)]
                            (if (and all-pages? (-> resp meta :links :next))
                              (let [new-req (update-req req (-> resp meta :links :next))]
                                (lazy-cat resp (exec-request new-req)))
                              resp)))]
       (exec-request req))))
