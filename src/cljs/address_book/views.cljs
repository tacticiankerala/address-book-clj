(ns address-book.views
  (:require [re-frame.core :as re-frame]))

(defn home-panel
  []
  (fn []
    [:h1 "It works!!"]))

(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      (panels @active-panel))))
