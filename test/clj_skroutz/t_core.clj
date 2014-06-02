(ns clj_skroutz.t-core
  (:use midje.sweet)
  (:use [clj_skroutz.core]))

(facts "about `build-request`"
  (fact ))

(facts "about `format-url`"
  (fact "it formats urls"
    (format-url "category")
      => "https://api.skroutz.gr/category"
    (format-url "categories/%s/children" [42])
      => "https://api.skroutz.gr/categories/42/children"
    (format-url "categories/%s/manufacturers/%s" [42 12])
      => "https://api.skroutz.gr/categories/42/manufacturers/12"
    ))
