(ns clj_skroutz.core
  (require [clj-http.client :as client])
  (require [cheshire.core :as json]))

(def ^:dynamic url "https://api.skroutz.gr/")
(def ^:dynamic user-agent "clj-skroutz client")
(def ^:dynamic accept-header "application/vnd.skroutz+json;version=3")

(defn format-url
  ([end-point]
    (format-url end-point ""))
  ([end-point positional]
   (str url (apply format end-point positional))))

(defn build-request
  "Builds a request to Skroutz API using some sane defaults."
  [method end-point positional &
   {:strs [throw_exceptions follow_redirects accept
           oauth_token user_agent]
    :or {follow_redirects true throw_exceptions false
         accept accept-header user_agent user-agent}
    :as query}]
  (let [req (merge-with merge
                        {:url (format-url end-point positional)
                         :throw-exceptions throw_exceptions
                         :follow-redirects follow_redirects
                         :method method}
                        (when accept
                          {:headers {"Accept" accept}})
                        (when oauth_token
                          {:headers {"Authorization" (str "Bearer " oauth_token)}})
                        (when user_agent
                          {:headers {"User-Agent" user_agent}})
                        )]
  req))

(defn api-response
  [{:keys [headers status body] :as response}]
  (cond
    (= 200 status)
      (json/parse-string body)))
