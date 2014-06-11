(ns clj_skroutz.t-core
  (:use midje.sweet)
  (:use [clj_skroutz.core]))

(facts "about `format-url`"
  (fact "it formats urls"
    (format-url "category")
      => "https://api.skroutz.gr/category"
    (format-url "categories/%s/children" [42])
      => "https://api.skroutz.gr/categories/42/children"
    (format-url "categories/%s/manufacturers/%s" [42 12])
      => "https://api.skroutz.gr/categories/42/manufacturers/12"
    ))

(facts "about `build-request`"
  (fact "it builds requests using `format-url` sets default accept header"
    (build-request :get "categories/%s" [10] {}) =>
     {:follow-redirects true, :method :get, :throw-exceptions false,
      :url "https://api.skroutz.gr/categories/10"
      :headers {"Accept" "application/vnd.skroutz+json;version=3"
                "User-Agent" "clj-skroutz client"}})

  (fact "it sets correct oauth header when oauth_token is passed as param"
    (:headers (build-request :get "categories/%s" [10], {"oauth_token" "an-oauth-token"}))
      =>  {"Accept" "application/vnd.skroutz+json;version=3"
           "Authorization" "Bearer an-oauth-token"
           "User-Agent" "clj-skroutz client"})

  (fact "it sets correct user-agent when user-agent is passed as param"
    (:headers (build-request :get "categories/%s" [10], {"user_agent" "a-user-agent"}))
      =>  {"Accept" "application/vnd.skroutz+json;version=3"
           "User-Agent" "a-user-agent"}))

(facts "about `api-response`"
  (fact "it returns nil if status is 204"
    (api-response {:status 204}) => nil)
  (fact "it returns ::not-modified if status is 304"
    (api-response {:status 304}) => nil)
  (fact "it returns response with body parsed if status is 400"
    (api-response {:status 400 :body "{\"foo\":\"bar\"}"})
    => {:body {"foo" "bar"} :status 400})
  (fact "it returns response with body parsed if status is 401"
    (api-response {:status 401 :body "{\"foo\":\"bar\"}"})
    => {:body {"foo" "bar"} :status 401})
  (fact "it returns response with body parsed if status is 403"
    (api-response {:status 403 :body "{\"foo\":\"bar\"}"})
    => {:body {"foo" "bar"} :status 403})
  (fact "it returns response with body parsed if status is 404"
    (api-response {:status 404 :body "{\"foo\":\"bar\"}"})
    => {:body {"foo" "bar"} :status 404})
  (fact "it returns response with body parsed if status is 422"
    (api-response {:status 422 :body "{\"foo\":\"bar\"}"})
    => {:body {"foo" "bar"} :status 422})
  (fact "it returns response with body parsed if status is 500"
    (api-response {:status 500 :body "{\"foo\":\"bar\"}"})
    => {:body {"foo" "bar"} :status 500}))
