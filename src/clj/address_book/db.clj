(ns address-book.db
  (:require [environ.core :refer [env]]
            [korma.db :as korma-db]))

(def db-url
  (let [db-user     (env :db-user)
        db-password (env :db-password)
        db-host     (env :db-host)
        db-port     (env :db-port)
        database    (env :database)]
    (str "postgres://"
         (when-not (empty? db-user)
           (str db-user ":" db-password "@"))
         db-host ":" db-port "/" database)))


(def migratus-config {
                      :store         :database
                      :migration-dir "migrations"
                      :db            db-url
                      })

(def korma-config {
                   })

(korma-db/defdb app-db (korma-db/postgres {:db       (env :database)
                                           :user     (env :db-user)
                                           :password (env :db-password)
                                           ;; optional keys
                                           :host     (env :db-host)
                                           :port     (env :db-port)}))
