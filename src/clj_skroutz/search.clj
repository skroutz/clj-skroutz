(ns clj_skroutz.search
  (:use [clj_skroutz.core :as skroutz]))

(defn search
  "Searches skroutz

  http://docs.skroutz.gr/apiv3/v3/search/#search-1"
  [q & options]
  (skroutz/api-call :get "search" [] (conj options ["query_params" {:q q}])))

