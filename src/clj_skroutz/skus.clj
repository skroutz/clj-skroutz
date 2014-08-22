(ns clj_skroutz.skus
  (:use [clj_skroutz.core :refer [api-call]]))

(defn sku
  "Gets a sku.

   http://developer.skroutz.gr/api/v3/sku/#retrieve-a-single-sku"
  [id & options]
  (api-call :get "skus/%s" [id] options))

(defn similar
  "Lists similar skus.

   http://developer.skroutz.gr/api/v3/sku/#retrieve-similar-skus"
  [id & options]
  (api-call :get "skus/%s/similar" [id] options))

(defn products
  "Lists sku's products.

   http://developer.skroutz.gr/api/v3/sku/#retrieve-a-skus-products"
  [id & options]
  (api-call :get "skus/%s/products" [id] options))

(defn reviews
  "Lists sku's reviews.

  http://developer.skroutz.gr/api/v3/sku/#retrieve-a-skus-reviews"
  [id & options]
  (api-call :get "skus/%s/reviews" [id] options))

(defn specifications
  "Lists sku's specifications.

   http://developer.skroutz.gr/api/v3/sku/#retrieve-a-skus-specifications"
  [id & options]
  (api-call :get "skus/%s/specifications" [id] options))