(ns clj_skroutz.categories
  "Implement Category endpoint http://docs.skroutz.gr/apiv3/v3/category/"
  (:use [clj_skroutz.core :as skroutz]))

(defn all
  "Lists all categories. Actually at the moment of writing this function lists
   only the family categories

   http://docs.skroutz.gr/apiv3/v3/category/#list-all-categories"
   [& options]
   (skroutz/api-call :get "categories" [] options))

(defn category
  "Lists a single category by id

  http://docs.skroutz.gr/apiv3/v3/category/#retrieve-a-single-category"
  [id & options]
  (skroutz/api-call :get "categories/%s" [id] options))

(defn parent
  "Lists the parent category

  http://docs.skroutz.gr/apiv3/v3/category/#retrieve-the-parent-of-a-category"
  [id & options]
  (skroutz/api-call :get "categories/%s/parent" [id] options))

(defn root
  "Lists the root category

  http://docs.skroutz.gr/apiv3/v3/category/#retrieve-the-root-category"
  [& options]
  (skroutz/api-call :get "categories/root" [] options))

(defn children
  "Lists the children of a category

  http://docs.skroutz.gr/apiv3/v3/category/#list-the-children-categories-of-a-category"
  [id & options]
  (skroutz/api-call :get "categories/%s/children" [id] options))

(defn manufacturers
  "Lists category manufacturers

  http://docs.skroutz.gr/apiv3/v3/category/#list-a-categorys-manufacturers"
  [id & options]
  (skroutz/api-call :get "categories/%s/manufacturers" [id] options))

(defn skus
  "Lists category skus

   http://docs.skroutz.gr/apiv3/v3/sku/#list-skus-of-specific-category"
   [id & options]
   (skroutz/api-call :get "categories/%s/skus" [id] options))

(defn filter-groups
  "Lists filter groups

  http://docs.skroutz.gr/apiv3/v3/filter_groups/#list-filtergroups"
  [id & options]
  (skroutz/api-call :get "categories/%s/filter_groups" [id] options))