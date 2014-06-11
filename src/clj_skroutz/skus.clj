(ns clj_skroutz.skus
  (:use [clj_skroutz.core :as skroutz]))

(defn from-category
  "Lists skus for a specific category"
  [id & options]
  (skroutz/api-call :get "categories/%s/skus" [id] options))

(defn sku
  "Gets sku"
  [id & options]
  (skroutz/api-call :get "skus/%s" [id] options))

(defn similar
  "Gets similar skus"
  [id & options]
  (skroutz/api-call :get "skus/%s/similar" [id] options))

(defn products
  "Lists sku's products"
  [id & options]
  (skroutz/api-call :get "skus/%s/products" [id] options))

(defn reviews
  "Lists sku's reviews"
  [id & options]
  (skroutz/api-call :get "skus/%s/reviews" [id] options))

(defn specifications
  "Lists specifications"
  [id & options]
  (skroutz/api-call :get "skus/%s/specifications" [id] options))