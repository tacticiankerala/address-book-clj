#Address Book

Simple address book with persistence.

Usage
-----
###Development
- `lein with-profile dev clean`
- `lein with-profile dev figwheel app` to run figwheel
- `lein with-profile dev run` to run server
- then visit `http://localhost:8080`

###Production
- `lein with-profile prod clean`
- `lein with-profile prod uberjar`
- run `java -jar target/address-book.jar`