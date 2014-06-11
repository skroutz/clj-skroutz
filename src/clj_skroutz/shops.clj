(ns clj_skroutz.shops
  (:use [clj_skroutz.core :as skroutz]))

(defn shop
  [id & options]
  (skroutz/api-call :get "shops/%s" [id] options))

(defn shop-reviews
  [id & options]
  (skroutz/api-call :get "shops/%s/reviews" [id] options))

(defn shop-locations
  [id & options]
  (skroutz/api-call :get "shops/%s/locations" [id] options))

(defn shop-location
  [id location-id & options]
  (skroutz/api-call :get "shops/%s/locations/%s" [id location-id] options))

(defn search
  [q & options]
  (skroutz/api-call :get "shops/search" [] (conj options [:q q])))