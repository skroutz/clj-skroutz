(defproject clj-skroutz "0.0.1"
  :description "A Clojure client for Skroutz API (v3 and above)"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.7.0"]
                 [cheshire "5.8.0"]
                 [com.cemerick/url "0.1.1"]
                 [ring/ring-core "1.6.3"]]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :url "https://github.com/skroutz/clj-skroutz"
  :profiles {:dev {:dependencies [[midje "1.9.0"]
                                  [sonian/carica "1.2.2"]]}})
