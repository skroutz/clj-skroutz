(ns clj_skroutz.products
  (:use [clj_skroutz.core :refer [api-call]]))

(defn product
  "Gets a product.

   http://developer.skroutz.gr/api/v3/product/#retrieve-a-single-product"
  [id & options]
  (api-call :get "products/%s" [id] options))