(ns clj_skroutz.products
  (:use [clj_skroutz.core :as skroutz]))

(defn product
  "Lists product"
  [id & options]
  (skroutz/api-call :get "products/%s" [id] options))