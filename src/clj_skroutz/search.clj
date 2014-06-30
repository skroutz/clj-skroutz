(ns clj_skroutz.search
  (:use [clj_skroutz.core :as skroutz]))

(defn search
  "Searches skroutz"
  [q & options]
  (skroutz/api-call :get "search" [] ["query_params" {:q q}]))
