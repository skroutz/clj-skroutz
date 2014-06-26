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

* __:token-url__ The url to grab tokens. _Default_ is `https://www.skroutz.gr/oauth2/token`
* __:scope__ The scope of client access. _Default_ is `public`
* __:grant-type__ The grant type of oauth access. _Default_ is `client_credentials`
* __:redirect-uri__ The redirect uri for callbacks. _Default_ is `http://www.example.com/callback`
* __:accept-header__ The accept header. _Default_ is `application/vnd.skroutz+json;version=3`
* __:user-agent__ The user agent info. _Default_ is `clj-skroutz client`
* __:url__ The url to consume api calls. _Default_ is `https://api.skroutz.gr/`
* __:client-id__ The client id.
* __:client-secret__ The client secret.
* __:app-token__ The app token.
* __:auth-prefix__ The authorization prefix. Default is `"Bearer "`

## How to get an application token

Once you have `client-id` and `client-secret` update your `config.edn` file and:

```clojure
(require 'clj_skroutz.oauth)
(clj_skroutz.oauth/app-token)
```

You should see a response with an `access-token`. Grab this token and add it to
`config.edn` too.  

## References

[Skroutz API documentation](http://docs.skroutz.gr/apiv3/)

## How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

## License

Distributed under the Eclipse Public License, the same as Clojure.
