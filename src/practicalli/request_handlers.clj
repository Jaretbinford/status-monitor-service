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
        [:div {:class "container" :align "center"}
         (link-to {:class "button is-primary"} "/scoreboard"  "Scoreboard")
         (link-to {:class "button is-danger"}  "/pics" "Woof!")
         [:p {:class "content"}
          "Where your true identities are tracked!"]
         [:img {:src "https://raw.githubusercontent.com/Jaretbinford/status-monitor-service/master/src/mafiadog.jpg"}]]]
       ])))

(defn scoreboard
  [request]
  (response
    (html5
  [:div
   [:h1 "Mafia Scoreboard!"]
   [:img {:src "https://raw.githubusercontent.com/Jaretbinford/status-monitor-service/master/src/mafiadog.jpg"}]])))

(defn pictures
  [request]
  (response
    (html5
      [:div
       [:h1 "Mafia Scoreboard!"]
       [:img {:src "https://raw.githubusercontent.com/Jaretbinford/status-monitor-service/master/src/mafiadog.jpg"}]])))

