(ns clj_skroutz.favorites
  "Implements user favorites endpoints.

   http://developer.skroutz.gr/api/v3/favorites/"
   (:use [clj_skroutz.core :refer [api-call]]))

(defn all
  "Lists favorites.

   http://developer.skroutz.gr/api/v3/favorites/#list-favorites"
  [& options]
  (api-call :get "favorites" [] options))

(defn favorite
  "Gets a favorite.

   http://developer.skroutz.gr/api/v3/favorites/#retrieve-a-single-favorite"
  [id & options]
  (api-call :get "favorites/%s" [id] options))

(defn create
  "Creates a new favorite.

   http://developer.skroutz.gr/api/v3/favorites/#create-a-new-favorite"
  [sku_id & options]
  (api-call :post "favorites" [] (conj options ["query_params" {"favorite[sku_id]" sku_id}])))

(defn destroy
  "Destroys a favorite.

   http://developer.skroutz.gr/api/v3/favorites/#destroy-a-favorite"
  [id & options]
  (api-call :delete "favorites/%s" [id] options))

(defn update
  "Updates a favorite.

   http://developer.skroutz.gr/api/v3/favorites/#update-a-favorite"
  [id & options]
  (api-call :put "favorites/%s" [id] options))
