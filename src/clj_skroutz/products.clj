(ns clj_skroutz.products
  (:use [clj_skroutz.core :as skroutz]))

(defn product
  "Gets a single product

  http://docs.skroutz.gr/apiv3/v3/product/#retrieve-a-single-product"
  [id & options]
  (skroutz/api-call :get "products/%s" [id] options))