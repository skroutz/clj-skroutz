(ns clj_skroutz.search
  (:use [clj_skroutz.core :refer [api-call]]))

(defn search
  "Searches Skroutz

   http://docs.skroutz.gr/apiv3/v3/search/#search-1"
  [q & options]
  (api-call :get "search" [] (conj options ["query_params" {:q q}])))


(defn autocomplete
  "Autocompletes from Skroutz

   http://docs.skroutz.gr/apiv3/v3/search/#autocomplete"
  [q & options]
  (api-call :get "autocomplete" [] (conj options ["query_params" {:q q}])))