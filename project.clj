(defproject clj-skroutz "0.0.1-SNAPSHOT"
  :description "A Clojure client for Skroutz API (v3 and above)"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "0.9.2"]
                 [cheshire "5.3.1"]
                 [com.cemerick/url "0.1.1"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]}})
