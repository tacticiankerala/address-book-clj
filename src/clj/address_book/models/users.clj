(ns address-book.models.users
  (:use [korma.core]))

(defentity users
  (pk :email)
  (entity-fields :id :name :email))
