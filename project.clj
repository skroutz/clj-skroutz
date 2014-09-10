(defproject clj-skroutz "0.0.1"
  :description "A Clojure client for Skroutz API (v3 and above)"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "0.9.2"]
                 [cheshire "5.3.1"]
                 [com.cemerick/url "0.1.1"]
                 [ring/ring-core "1.3.0"]]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :url "https://github.com/skroutz/clj-skroutz"
  :profiles {:dev {:dependencies [[midje "1.6.3"]
                                  [sonian/carica "1.1.0"]]}})
