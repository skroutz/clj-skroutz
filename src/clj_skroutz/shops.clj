(ns clj_skroutz.shops
  "Implements shop endpoints."
  (:use [clj_skroutz.core :refer [api-call]]))

(defn shop
  "Gets a shop.

   http://developer.skroutz.gr/api/v3/shop/#retrieve-a-single-shop"
  [id & options]
  (api-call :get "shops/%s" [id] options))

(defn reviews
  "Lists shop's reviews.

   http://developer.skroutz.gr/api/v3/shop/#retrieve-a-shops-reviews"
  [id & options]
  (api-call :get "shops/%s/reviews" [id] options))

(defn locations
  "Lists shop's locations.

   http://developer.skroutz.gr/api/v3/shop/#list-shop-locations"
  [id & options]
  (api-call :get "shops/%s/locations" [id] options))

(defn search
  "Searches shops

   http://developer.skroutz.gr/api/v3/shop/#search-for-shops"
  [q & options]
  (api-call :get "shops/search" [] (conj options ["query_params" {:q q}])))

(defn location
  [id location-id & options]
  (api-call :get "shops/%s/locations/%s" [id location-id] options))
