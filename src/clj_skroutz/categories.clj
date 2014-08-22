(ns clj_skroutz.categories
  "Implements category endpoints.

   http://developer.skroutz.gr/api/v3/category/"
  (:require [clj_skroutz.core :refer (api-call)]))

(defn all
  "Lists all categories.

   http://developer.skroutz.gr/api/v3/category/#list-all-categories"
   [& options]
   (api-call :get "categories" [] options))

(defn category
  "Gets a category.

   http://developer.skroutz.gr/api/v3/category/#retrieve-a-single-category"
  [id & options]
  (api-call :get "categories/%s" [id] options))

(defn parent
  "Gets category's parent.

   http://developer.skroutz.gr/api/v3/category/#retrieve-the-parent-of-a-category"
  [id & options]
  (api-call :get "categories/%s/parent" [id] options))

(defn root
  "Gets root category.

   http://developer.skroutz.gr/api/v3/category/#retrieve-the-root-category"
  [& options]
  (api-call :get "categories/root" [] options))

(defn children
  "Lists category's children.

   http://developer.skroutz.gr/api/v3/category/#list-the-children-categories-of-a-category"
  [id & options]
  (api-call :get "categories/%s/children" [id] options))

(defn manufacturers
  "Lists category's manufacturers.

   http://developer.skroutz.gr/api/v3/category/#list-a-categorys-manufacturers"
  [id & options]
  (api-call :get "categories/%s/manufacturers" [id] options))

(defn skus
  "Lists category's skus.

   http://developer.skroutz.gr/api/v3/sku/#list-skus-of-specific-category"
   [id & options]
   (api-call :get "categories/%s/skus" [id] options))

(defn filter-groups
  "Lists category's filter groups.

   http://developer.skroutz.gr/api/v3/filter_groups/#list-filtergroups"
  [id & options]
  (api-call :get "categories/%s/filter_groups" [id] options))