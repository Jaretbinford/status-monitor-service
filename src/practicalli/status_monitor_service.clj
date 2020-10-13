(ns practicalli.status-monitor-service
  (:gen-class)
  (:require [org.httpkit.server  :as app-server]
            [compojure.core      :refer [defroutes GET]]
            [compojure.route     :refer [not-found]]
            [ring.handler.dump   :refer [handle-dump]]
            [ring.util.response  :refer [response]]))

;request handler

(defn dashboard
  [request]
  (response "Status Monitor Dashboard via CircleCI and Heroku"))

;default route handler application

(defroutes status-monitor
           (GET "/" [] dashboard)
           (GET "/request-dump" [] handle-dump))

;functions

(defonce app-server-instance (atom nil))

(defn stop-app-server
  "Gracefully shutdown the server after waiting 100ms"
  []
  (when-not (nil? @app-server-instance)
    (@app-server-instance :timeout 100)
    (reset! app-server-instance nil)
    (println "INFO: Application server stopped!")))


(defn -main
  "Start the application server and run the application"
  [port]
  (println "INFO: Starting server on port: " port)

  (reset! app-server-instance
          (app-server/run-server #'status-monitor {:port (Integer/parseInt port)})))


(defn restart-app-server
  "Function to stop and start the application server"
  []
  (stop-app-server)
  (-main))

(comment
  ;start
  (-main "8001")
  ;stop
  (stop-app-server)
  ;restart
  (restart-app-server)
  )







