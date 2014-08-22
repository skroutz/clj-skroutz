(ns clj_skroutz.manufacturers
  "Implements manufacturer endpoints"
  (:use [clj_skroutz.core :refer [api-call]]))

(defn all
  "Lists all manufacturers.

   http://developer.skroutz.gr/api/v3/manufacturer/#list-manufacturers"
  [& options]
  (api-call :get "manufacturers" [] options))

(defn manufacturer
  "Gets a manufacturer.

   http://developer.skroutz.gr/api/v3/manufacturer/#retrieve-a-single-manufacturer"
  [id & options]
  (api-call :get "manufacturers/%s" [id] options))

(defn categories
  "Lists manufacturer's categories.

   http://developer.skroutz.gr/api/v3/manufacturer/#retrieve-a-manufacturers-categories"
  [id & options]
  (api-call :get "manufacturers/%s/categories" [id] options))

(defn skus
  "Lists manufacturer's skus.

   http://developer.skroutz.gr/api/v3/manufacturer/#retrieve-a-manufacturers-skus"
  [id & options]
  (api-call :get "manufacturers/%s/skus" [id] options))