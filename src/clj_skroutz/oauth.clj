(ns clj_skroutz.oauth
  (require [clj-http.client :as client])
  (require [cheshire.core   :as json])
  (require [clj_skroutz.core])
  (require [carica.core :as carica]))

(defn app-token
  "Posts request for application token given client-id and client-secret."
  [& {:keys [client-id client-secret redirect-uri grant-type scope token-url
             accept-header code]
    :or   {client-id (carica/config :client-id)
           client-secret (carica/config :client-secret)
           redirect-uri (carica/config :redirect-uri)
           grant-type (carica/config :grant-type)
           scope (carica/config :scope)
           token-url (carica/config :token-url)
           accept-header (carica/config :accept-header)}}]
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
    :or   {client-id (carica/config :client-id)
           client-secret (carica/config :client-secret)
           redirect-uri (carica/config :redirect-uri)
           grant-type (carica/config :grant-type)
           scope (carica/config :scope)
           token-url (carica/config :token-url)
           accept-header (carica/config :accept-header)}}]
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
