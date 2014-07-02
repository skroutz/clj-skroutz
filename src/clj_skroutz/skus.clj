(ns clj_skroutz.skus
  (:use [clj_skroutz.core :as skroutz]))

(defn sku
  "Gets a single SKU

  http://docs.skroutz.gr/apiv3/v3/sku/#retrieve-a-single-sku"
  [id & options]
  (skroutz/api-call :get "skus/%s" [id] options))

(defn similar
  "Gets similar SKUs

  http://docs.skroutz.gr/apiv3/v3/sku/#retrieve-similar-skus"
  [id & options]
  (skroutz/api-call :get "skus/%s/similar" [id] options))

(defn products
  "Gets SKU's products

  http://docs.skroutz.gr/apiv3/v3/sku/#retrieve-a-skus-products"
  [id & options]
  (skroutz/api-call :get "skus/%s/products" [id] options))

(defn reviews
  "Gets SKU's reviews

  http://docs.skroutz.gr/apiv3/v3/sku/#retrieve-a-skus-reviews"
  [id & options]
  (skroutz/api-call :get "skus/%s/reviews" [id] options))

(defn specifications
  "Gets SKU's specifications

  http://docs.skroutz.gr/apiv3/v3/sku/#retrieve-a-skus-specifications"
  [id & options]
  (skroutz/api-call :get "skus/%s/specifications" [id] options))