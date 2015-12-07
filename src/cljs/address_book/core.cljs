(ns address-book.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [address-book.handlers]
            [address-book.subs]
            [address-book.routes :as routes]
            [address-book.views :as views]))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
