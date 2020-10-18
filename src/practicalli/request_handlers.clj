(ns practicalli.request-handlers
  (:require [ring.util.response :refer [response]]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [html5 include-js include-css]]
            [hiccup.element :refer [link-to]]))

(defn welcome-page
  [request]
  (response
    (html5
      {:lang "en"}
      [:head
       (include-css "https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css")]
      [:body
       [:section {:class "hero is-info"}
        [:div {:class "hero-body"}
         [:div {:class "container"}
          [:h1 {:class "title"} "Mafia Scoreboard"]
          [:p {:class "subtitle"}
           "Where the dog's keep score"]]]]

       [:section {:class "section"}
        [:div {:class "container"}
         (link-to {:class "button is-primary"} "/scoreboard"  "Login")
         (link-to {:class "button is-danger"}  "/register" "Register")
         [:p {:class "content"}
          "Manage your money without unexpected side-effects using a simple made easy banking service"]
         [:img {:src "https://github.com/Jaretbinford/status-monitor-service/blob/master/src/mafiadog.jpg"}]]]
       ])))

(defn scoreboard
  [request]
  (response
  [:div
   [:h1 "Mafia Scoreboard!"]
   [:img {:src "https://github.com/Jaretbinford/status-monitor-service/blob/master/src/mafiadog.jpg"}]]))