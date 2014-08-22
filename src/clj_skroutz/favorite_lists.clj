(ns clj_skroutz.favorite_lists
  "Implements user favorite lists endpoints.

   http://developer.skroutz.gr/api/v3/favorites/"
  (:use [clj_skroutz.core :refer [api-call]]))

(defn all
  "Lists all favorite lists of a user.

   http://developer.skroutz.gr/api/v3/favorites/#list-favorite-lists"
   [& options]
   (api-call :get "favorite_lists" [] options))

(defn create
  "Creates a new favorite list.

   http://developer.skroutz.gr/api/v3/favorites/#create-a-favoritelist"
  [name & options]
  (api-call :post "favorite_lists" []
            (conj options ["query_params" {"favorite_list[name]" name}])))

(defn destroy
  "Destroys a favorite list.

   http://developer.skroutz.gr/api/v3/favorites/#destroy-a-favoritelist"
  [id & options]
  (api-call :delete "favorite_lists/%s" [id] options))

(defn favorites
  "Lists favorites from a list.

   http://developer.skroutz.gr/api/v3/favorites/#list-favorites-belonging-to-list"
  [id & options]
  (api-call :get "favorite_lists/%s/favorites" [id] options))
