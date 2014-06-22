(ns clj_skroutz.oauth
  (require [clj-http.client :as client])
  (require [cheshire.core   :as json])
  [require [clj_skroutz.core]])

(defn app-token
  "Posts request for application token given client-id and client-secret."
  [client-id client-secret &
    {:keys [redirect-uri grant-type scope token-url accept-header]
     :or   {redirect-uri "http://www.example.com/callback"
            grant-type "client_credentials"
            scope "public"
            token-url "https://www.skroutz.gr/oauth2/token"
            accept-header clj_skroutz.core/accept-header}}]
  (client/post token-url
    {:headers {"ACCEPT" accept-header}
     :form-params {:client_id client-id,
                   :client_secret client-secret,
                   :redirect_uri redirect-uri
                   :grant_type grant-type
                   :scope scope}}))
