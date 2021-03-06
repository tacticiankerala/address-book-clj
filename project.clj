(defproject address-book-clj "0.1.0-SNAPSHOT"
  :description "Simple address book with persistence"
  :url ""
  :license {:name "MIT"
            :url "https://tldrlegal.com/license/mit-license"}

  :source-paths ["src/clj/"]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-servlet "1.4.0"]
                 [ring/ring-jetty-adapter  "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [compojure "1.4.0"]

                 [environ "1.0.1"]

                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [korma "0.4.0"]
                 [migratus "0.8.8"]

                 [reagent "0.5.1"]
                 [re-frame "0.5.0"]
                 [secretary "1.2.3"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-environ "1.0.1"]]

  :min-lein-version "2.5.0"

  :env {
        :port        "8080"

        :db-user     "sreenath"
        :db-password ""
        :db-host     "localhost"
        :db-port     "5432"
        :database    "address-book-dev"
        }

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "resources/private/js/compiled" "target"]

  :uberjar-name "address-book.jar"

  :main ^{:skip-aot true} address-book.server

  :cljsbuild {
              :builds {
                       :app {
                             :source-paths ["src/cljs"]
                             :compiler {
                                        :main address-book.core
                                        :output-to "resources/public/js/compiled/app.js"
                                        :output-dir "resources/public/js/compiled/out"
                                        :asset-path "js/compiled/out"
                                        :optimizations :none
                                        :pretty-print  true
                                        }}}}

  :profiles {
             :dev     {
                       :dependencies [[ring/ring-devel  "1.4.0"]
                                      [org.clojure/tools.nrepl "0.2.11"]]
                       :env          {:dev true}
                       :plugins      [[lein-figwheel "0.5.0-2"]
                                      [migratus-lein "0.2.0"]]
                       :cljsbuild    { :builds { :app {
                                                       :figwheel {
                                                                  :http-server-root "public"
                                                                  :css-dirs ["resources/public/css"]
                                                                  :on-jsload "address-book.core/mount-root"
                                                                  }
                                                       :compiler {
                                                                  :source-map-timestamp true
                                                                  }}}}}
             :uberjar {
                       :env {:production true}
                       :hooks [leiningen.cljsbuild]
                       :omit-source true
                       :aot :all
                       :main address-book.server
                       :cljsbuild { :builds { :app {
                                                    :compiler {
                                                               :optimizations :advanced
                                                               :pretty-print false}}}}}
             :test    {
                       :dependencies [[speclj "3.3.0"]]
                       :plugins      [[speclj "3.3.0"]]
                       :test-paths   ["spec/clj"]
                       :env          {:test true}
                       :cljsbuild    { :builds       { :app {
                                                             :source-paths   ["src/cljs" "spec/cljs"]
                                                             :compiler       {
                                                                              :output-to     "resources/private/js/compiled/unit-test.js"
                                                                              :output-dir    "resources/private/js/compiled/out"
                                                                              :asset-path    "js/compiled/out"
                                                                              :optimizations :whitespace ;;:none requires more complex setup, at least in the browser
                                                                              :pretty-print  true
                                                                              }}}
                                      :test-commands { "test" ["phantomjs"
                                                               "resources/private/js/phantomjs-runner.js"
                                                               "resources/private/js/compiled/unit-test.js"
                                                               ]}}}})
