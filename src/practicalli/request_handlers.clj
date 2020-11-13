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


(defn player-score
  [player-details]
  [:article {:class "media"}
   [:figure {:class "media-left"}
    [:p {:class "image is-64x64"}
     [:img {:src "https://raw.githubusercontent.com/Jaretbinford/status-monitor-service/master/src/mafiadog2.jpg"}]]]
   [:div {:class "media-content"}
    [:div {:class "content"}
     [:h3 {:class "subtitle"}
      (str (:player-name player-details) " : &lambda;" (:player-score player-details))]]

    [:div {:class "field is-grouped"}
     [:div {:class "control"}
      [:div {:class "tags has-addons"}
       [:span {:class "tag"} "Account number"]
       [:span {:class "tag is-success is-light"} (:player-id player-details)]]]

     [:div {:class "tags has-addons"}
      [:span {:class "tag"} "Sort Code"]
      [:span {:class "tag is-success is-light"} (:player-sort player-details)]]]]

   [:div {:class "media-right"}
    (link-to {:class "button is-primary"} "/view-profile" "Profile")
    (link-to {:class "button is-info"} "/Record" "Record")]])

(defn scoreboard
  "Scoreboard for mafia page"

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
        (player-score {:player-name  "Chloe" :player-id    "123456789"
                       :player-score "50,234"           :player-sort "1"})

        (player-score {:player-name  "Xander" :player-id    "123456789"
                       :player-score "44,244"           :player-sort "2"})

        (player-score {:player-name  "Ben" :player-id    "123456789"
                       :player-score "17,234"           :player-sort "3"})

        (player-score {:player-name  "Sarah" :player-id    "123456789"
                       :player-score "10,234"           :player-sort "4"})

        (player-score {:player-name  "Clare" :player-id    "123456789"
                       :player-score "1,234"           :player-sort "5"})

        (player-score {:player-name  "Carter" :player-id    "123456789"
                       :player-score "1,234"           :player-sort "6"})

        (player-score {:player-name  "Carter" :player-id    "123456789"
                       :player-score "1,234"           :player-sort "7"})

        (player-score {:player-name  "Allie" :player-id    "123456789"
                       :player-score "1,234"           :player-sort "8"})

        (player-score {:player-name  "Alex" :player-id    "123456789"
                       :player-score "1,234"           :player-sort "9"})

        (player-score {:player-name  "Jaret" :player-id    "123456789"
                       :player-score "1,234"           :player-sort "10"})



        ]])))

(defn pictures
  [request]
  (response
    (html5
      [:div
       [:h1 "Mafia Scoreboard!"]
       [:img {:src "https://raw.githubusercontent.com/Jaretbinford/status-monitor-service/master/src/mafiadog.jpg"}]])))

