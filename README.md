# clj-skroutz

A Clojure client for Skroutz API (v3 and above).
Please check the [documentation](http://docs.skroutz.gr/apiv3/) for more
information.

The project uses [Midje](https://github.com/marick/Midje/).

## Install

In your project add
```clojure
[clj_skroutz "0.0.1"]
````

## Configure

There a couple of configurations you can make. In your `resources` folder
add `config.edn`. Options for `clj_skroutz` are:

* :token-url The url to grab tokens. Default is `https://www.skroutz.gr/oauth2/token`
* :scope The scope of client access. Default is `public`
* :grant-type The grant type of oauth access. Default is `client_credentials`
* :redirect-url The redirect uri for callbacks. Default is `http://www.example.com/callback`
* :accept-header The accept header. Default is `application/vnd.skroutz+json;version=3`
* :user-agent The user agent info. Default is `clj-skroutz client`
* :url The url to consume api calls. Default is `https://api.skroutz.gr/`
* :client-id The client id.
* :client-secret The client secret.
* :app-token The app token.

## How to get an application token

Once you have `client-id` and `client-secret` update your `config.edn` file and:

```clojure
(require 'clj_skroutz.oauth)
(clj_skroutz.oauth/app-token)
```

You should see a response with an `app-token`. Grab this token and add it to
`config.edn` too.

## How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

## License

Distributed under the Eclipse Public License, the same as Clojure.
