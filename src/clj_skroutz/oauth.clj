(ns clj_skroutz.oauth
  (require [clj-http.client :as client])
  (require [cheshire.core   :as json])
  (require [clj_skroutz.core])
  (require [ring.util.codec :refer (url-decode)]))

(defn app-token
  "Posts request for application token given client-id and client-secret."
  [& {:keys [client-id client-secret redirect-uri grant-type scope token-url
             accept-header code]
    :or   {client-id (:client-id clj_skroutz.core/current-profile)
           client-secret (:client-secret clj_skroutz.core/current-profile)
           redirect-uri (:redirect-uri clj_skroutz.core/current-profile)
           grant-type (:grant-type clj_skroutz.core/current-profile)
           scope (:scope clj_skroutz.core/current-profile)
           token-url (:token-url clj_skroutz.core/current-profile)
           accept-header (:accept-header clj_skroutz.core/current-profile)}}]
  (client/post token-url
    {:headers {"ACCEPT" accept-header}
     :form-params {:client_id client-id,
                   :client_secret client-secret,
                   :redirect_uri redirect-uri
                   :grant_type grant-type
                   :scope scope
                   :code code}}))

(defn user-code
  "Gets an authorization code for user specific actions. Examples are
   notifications favorites and so on.

   http://docs.skroutz.gr/apiv3/guides/authentication/"
  [& {:keys [client-id client-secret redirect-uri grant-type scope token-url
             accept-header code]
    :or   {client-id (:client-id clj_skroutz.core/current-profile)
           client-secret (:client-secret clj_skroutz.core/current-profile)
           redirect-uri (:redirect-uri clj_skroutz.core/current-profile)
           grant-type (:grant-type clj_skroutz.core/current-profile)
           scope (:scope clj_skroutz.core/current-profile)
           token-url (:token-url clj_skroutz.core/current-profile)
           accept-header (:accept-header clj_skroutz.core/current-profile)}}]
  (client/get "https://www.skroutz.gr/oauth2/authorizations/new"
    {:follow-redirects false,
     :query-params {:client_id client-id,
                    :redirect_uri redirect-uri
                    :scope "public favorites override_users_approval"
                    :response_type "code"}}))

(defn user-token
  "Gets a user authentication token"
  [code]
  (app-token :code code, :grant-type "authorization_code"))

(defn decode-user-code
  "Decodes user code as given by the redirect url"
  [code]
  (url-decode code))