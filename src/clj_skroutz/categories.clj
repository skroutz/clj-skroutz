(ns clj_skroutz.categories
  "Implement Category endpoint http://docs.skroutz.gr/apiv3/v3/category/"
  (:use [clj_skroutz.core :as skroutz]))

(defn all
  "Lists all categories. Actually at the moment of writing this function lists
   only the family categories"
   [& options]
   (skroutz/api-call :get "categories" [] options))

(defn category
  "Lists a single category by id"
  [id & options]
  (skroutz/api-call :get "categories/%s" [id] options))

(defn parent
  "Lists the parent category"
  [id & options]
  (skroutz/api-call :get "categories/%s/parent" [id] options))

(defn root
  "Lists the root category"
  [& options]
  (skroutz/api-call :get "categories/root" [] options))

(defn children
  "Lists the children of a category"
  [id & options]
  (skroutz/api-call :get "categories/%s/children" [id] options))

(defn manufacturers
  "Lists category manufacturers"
  [id & options]
  (skroutz/api-call :get "categories/%s/manufacturers" [id] options))