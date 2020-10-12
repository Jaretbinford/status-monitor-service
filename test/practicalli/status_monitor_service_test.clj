(ns practicalli.status-monitor-service-test
  (:require [clojure.test :refer :all]
            [clojure.test :refer [deftest is testing]]
            [ring.mock.request :as mock]
            [practicalli.status-monitor-service :as SUT]))


(deftest dashboard-test
  (testing "Testing elements on the dashboard"
    (is (= (SUT/dashboard (mock/request :get "/"))
           {:status  200
            :body    "Status Monitor Dashboard via CircleCI and Heroku"
            :headers {}}))))

(defn check-ip-handler [request]
  (ring.util.response/content-type
    (ring.util.response/response (:remote-addr request))
    "text/plain"))
;testing CI

(comment
(ring.util.response/bad-request "Hello")
(ring.util.response/created "/post/clojure-is-awesome")
(ring.util.response/redirect "https://clojure.org/getting-started/")
(ring.util.response/status (ring.util.response/response "Time for Cake!") 555)
(ring.util.response/content-type (ring.util.response/response "Hello") "text/plain")
(ring.util.response/header (ring.util.response/response "Hello") "X-Tutorial-For" "Baeldung")
(ring.util.response/set-cookie (ring.util.response/response "Hello") "User" "123")
(check-ip-handler (ring.util.response/bad-request "Hello"))
)