# clj-skroutz

A Clojure client for Skroutz API (v3 and above).
Please check the [documentation](http://docs.skroutz.gr/apiv3/) for more
information.

The project uses [Midje](https://github.com/marick/Midje/).

## How to get an application token

Once you have `client-id` and `client-secret`

```clojure
(require 'clj_skroutz.oauth)
(clj_skroutz.oauth/app-token <your-client-id> <your-client-secret>)
```

## How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

## License

Distributed under the Eclipse Public License, the same as Clojure.