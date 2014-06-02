(ns clj_skroutz.core
  (require [clj-http.client :as client])
  (require [cheshire.core :as json]))

(def ^:dynamic url "https://api.skroutz.gr/")

(defn format-url
  ([end-point]
    (format-url end-point ""))
  ([end-point positional]
   (str url (apply format end-point positional))))

