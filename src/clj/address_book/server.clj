(ns address-book.server
  (:gen-class)
  (:require [ring.middleware.defaults :as ring-defaults]
            [ring.adapter.jetty :as jetty]
            [address-book.app :as app]
            [environ.core :refer [env]]))

(def site
  (ring-defaults/wrap-defaults app/app-routes ring-defaults/site-defaults))

(defn -main
  [& args]
  (jetty/run-jetty site {:port (Integer/parseInt (env :port))}))
