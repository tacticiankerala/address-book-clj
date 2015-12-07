(ns address-book.app
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            [ring.util.response :refer [redirect]]))


(defroutes app-routes
  (GET "/" [] (redirect "index.html"))
  (route/resources "/")
  (route/not-found "<h1>Page Not Found...</h1>"))
