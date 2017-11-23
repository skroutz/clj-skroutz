# clj-skroutz
[![Dependencies Status](https://versions.deps.co/skroutz/clj-skroutz/status.svg)](https://versions.deps.co/skroutz/clj-skroutz)

A Clojure client for Skroutz API (v3 and above).
Please check the [documentation](http://developer.skroutz.gr/api/v3/) for more
information.

## Installation

lein:

```clojure
[clj_skroutz "0.0.1"]
````
[Clojars](https://clojars.org/clj-skroutz)

## Configurations

* __:token-url__

  The url to grab app tokens. Can be `https://www.skroutz.gr/oauth2/token` or
  `https://www.alve.com/oauth2/token`.

* __:scope__

  The scope of client access. Check [here](http://developer.skroutz.gr/authorization/permissions/)
  for details.

* __:grant-type__

  The grant type of oauth access. Can be `client_credentials` or `authorization_code`.

* __:redirect-uri__

  The redirect uri for callbacks.

* __:accept-header__

  The accept header. Can be `application/vnd.skroutz+json;version=3` or
  `application/vnd.alve+json;version=3`.

* __:user-agent__

  The user agent info.

* __:url__

  The url to consume api calls. Can be `https://api.skroutz.gr/` or `https://api.alve.com/`

* __:client-id__

  The client id. See [here](http://developer.skroutz.gr/authorization/) for details.

* __:client-secret__

  The client secret. See [here](http://developer.skroutz.gr/authorization/) for details.

* __:app-token__

  The generated app token.

* __:auth-prefix__

  The authorization prefix. Must be `"Bearer "`

* __:user-code__

  The user code. See [here](http://developer.skroutz.gr/authorization/) for details.

## Profiles

To simplify working with multiple users or flavors (Skroutz, Alve) one can use
the macro `with-profile`. Each profile should be a hashmap with the appropriate
configuration options.

```clojure
  (use 'clj_skroutz.core)
  (require 'clj_skroutz.categories)

  ; Suppose we use carica for loading configs
  (def skroutz-public (carica.core/config :skroutz-public))
  (with-profile skroutz-public (clj_skroutz.categories/all))
```

## How to get an application token

Before proceed read documentation [here](http://developer.skroutz.gr/authorization/flows/).

1. __Application token:__

  Once you have `client-id` and `client-secret`:

  ```clojure
  (require 'clj_skroutz.oauth)
  (use 'clj_skroutz.core)

  (def my-profile {:redirect-uri "http://example.com/callback",
    :grant-type "client_credentials", :client-id "your-client-id",
    :user-agent "awesome client", :scope "public",
    :token-url "https://www.skroutz.gr/oauth2/token",
    :url "https://api.skroutz.gr/",
    :accept-header "application/vnd.skroutz+json;version=3",
    :client-secret "your-client-secret", :auth-prefix "Bearer "})

  (with-profile my-profile (clj_skroutz.oauth/app-token))  
  ```

  You should see a response with an `access-token`. Grab this token and you are
  ready to consume Skroutz API v3.

2. __User token:__

 Once you get a user code:

 ```clojure
   (require 'clj_skroutz.oauth)

   ; Decodes user code
   (def code (clj_skroutz.oauth/decode-user-code your-code-here))

   ; Continue from the previous example
   (def my-profile (conj my-profile {:user-code code, :grant-type "authorization_code"}))

   ; Grab app token
   (clj_skroutz.oauth/user-token code)
 ```

## Examples of Usage

1. Categories

```clojure
  ; Continue from the previous examples
  (require '[clj_skroutz.categories :as skroutz-categories])

  ; Gets specific category
  (with-profile my-profle (skroutz-categories/category 40))

  ; Gets root
  (with-profile my-profile (skroutz-categories/root))

  ; Lists skus for category
  (with-profile my-profile (skroutz-categories/skus 40))

  ; Lists skus for categories with ordering
  ; Available orderings are `popularity` and `pricevat`
  (with-profile my-profile (skroutz-categories/skus 40 [:order_by "popularity" :order_dir "desc"]))
```

## References

[Skroutz API documentation](http://developer.skroutz.gr/api/v3/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
