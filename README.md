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

###Production
- `lein clean`
- `lein uberjar`
- run `java -jar target/address-book.jar`

###Testing
- Prerequisite: [PhantomJS](https://www.npmjs.com/package/phantomjs)
- `lein clean`
- `lein with-profile test spec` to run Clojure tests
- `lein with-profile test cljsbuild test` to run ClojureScript tests