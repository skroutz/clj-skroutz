(ns clj_skroutz.oauth
  (require [clj-http.client :as client])
  (require [cheshire.core   :as json])
  (require [clj_skroutz.core])
  (require [carica.core :as carica]))

(defn app-token
  "Posts request for application token given client-id and client-secret."
  [& {:keys [client-id client-secret redirect-uri grant-type scope token-url
           accept-header]
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
                   :scope scope}}))
