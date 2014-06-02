(ns clj_skroutz.oauth
  (require [clj-http.client :as client])
  (require [cheshire.core   :as json])
  [require [clj_skroutz.core]])

(defn app-token
  [client-id client-secret &
    {:keys [redirect-uri grant-type scope]
     :or   {redirect-uri "http://www.example.com/callback"
            grant-type "client_credentials"
            scope "public"}}]
  (client/post "https://www.skroutz.gr/oauth2/token"
    {:headers {"ACCEPT" "application/vnd.skroutz+json;version=3"}
     :form-params {:client_id client-id,
                   :client_secret client-secret,
                   :redirect_uri redirect-uri
                   :grant_type grant-type
                   :scope scope}}))
