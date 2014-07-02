(ns clj_skroutz.manufacturers
  (:use [clj_skroutz.core :as skroutz]))

(defn manufacturers
  "Gets manufacturers

  http://docs.skroutz.gr/apiv3/v3/manufacturer/#list-manufacturers"
  [& options]
  (skroutz/api-call :get "manufacturers" [] options))

(defn manufacturer
  "Gets a single manufacturer

  http://docs.skroutz.gr/apiv3/v3/manufacturer/#retrieve-a-single-manufacturer"
  [id & options]
  (skroutz/api-call :get "manufacturers/%s" [id] options))

(defn categories
  "Gets manufacturer's categories

  http://docs.skroutz.gr/apiv3/v3/manufacturer/#retrieve-a-manufacturers-categories"
  [id & options]
  (skroutz/api-call :get "manufacturers/%s/categories" [id] options))

(defn skus
  "Gets manufacturer's SKUs

  http://docs.skroutz.gr/apiv3/v3/manufacturer/#retrieve-a-manufacturers-skus"
  [id & options]
  (skroutz/api-call :get "manufacturers/%s/skus" [id] options))