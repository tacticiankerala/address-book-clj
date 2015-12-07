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
                 [reagent "0.5.1"]
                 [re-frame "0.5.0"]
                 [secretary "1.2.3"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-environ "1.0.1"]]

  :min-lein-version "2.5.0"

  :env {:port "8080"}

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

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
             :dev {
                   :dependencies [[ring/ring-devel  "1.4.0"]
                                  [org.clojure/tools.nrepl "0.2.11"]]
                   :env {:dev true}
                   :plugins [[lein-figwheel "0.5.0-2"]]
                   :cljsbuild { :builds { :app {
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
                                                               :pretty-print false}}}}}})
