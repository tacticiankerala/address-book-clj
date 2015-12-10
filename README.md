#Address Book

Simple address book with persistence.

##[Demo](http://glacial-springs-9169.herokuapp.com/)

Usage
-----
###Development
- `lein clean`
- `lein with-profile dev figwheel app` to run figwheel
- `lein with-profile dev run` to run server
- then visit `http://localhost:8080`
- open clojure repl with `lein with-profile +dev repl`

###Production
- `lein clean`
- `lein uberjar`
- run `java -jar target/address-book.jar`

###Testing
- Prerequisite: [PhantomJS](https://www.npmjs.com/package/phantomjs)
- `lein clean`
- `lein with-profile test spec` to run Clojure tests
- `lein with-profile test cljsbuild test` to run ClojureScript tests

DB Migration
------------
- Run the following in REPL with a proper name for creating a new migration
```
(require '[migratus.core :as migratus])
(require '[address-book.db :as db])
(migratus/create db/migratus-config "<migration-name>")
```
- Latest migrations will be automatically run when the server restarts

Configurations
--------------
Set environment variables to configure the following,

- Server
--port `PORT`
- DB
-- user : `DB_USER`
-- password :`DB_PASSWORD`
-- host : `DB_HOST`
-- port : `DB_PORT`
-- database : `DATABASE`