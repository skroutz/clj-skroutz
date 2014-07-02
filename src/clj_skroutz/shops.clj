(ns clj_skroutz.shops
  (:use [clj_skroutz.core :as skroutz]))

(defn shop
  "Gets a single shop

  http://docs.skroutz.gr/apiv3/v3/shop/#retrieve-a-single-shop"
  [id & options]
  (skroutz/api-call :get "shops/%s" [id] options))

(defn reviews
  "Gets shop's reviews

  http://docs.skroutz.gr/apiv3/v3/shop/#retrieve-a-shops-reviews"
  [id & options]
  (skroutz/api-call :get "shops/%s/reviews" [id] options))

(defn locations
  "Gets shop's locations

  http://docs.skroutz.gr/apiv3/v3/shop/#list-shop-locations"
  [id & options]
  (skroutz/api-call :get "shops/%s/locations" [id] options))

(defn search
  "Searches shops

  http://docs.skroutz.gr/apiv3/v3/shop/#search-for-shops"
  [q & options]
  (skroutz/api-call :get "shops/search" [] (conj options [:q q])))  (skroutz/api-call :get "shops/search" [] (conj options ["query_params" {:q q}])))

(defn location
  [id location-id & options]
  (skroutz/api-call :get "shops/%s/locations/%s" [id location-id] options))
