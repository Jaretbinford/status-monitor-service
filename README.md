# status-monitor-service

An application to explore CircleCI and Heroku build and deploy integration.

## Installation

Download from https://github.com/practicalli/status-monitor-service

## Usage

Run the project directly:

    $ clojure -M -m practicalli.status-monitor-service

Run the project's tests (they'll fail until you edit them):

    $ clojure -M:test:runner

Build an uberjar:

    $ clojure -M:uberjar

Run that uberjar:

    $ java -jar status-monitor-service.jar
    
Stop the Heroku app by scaling down

    $ heroku ps:scale web=0 -a APPNAME-status-monitor-service
    $ heroku ps:scale -a APPNAME-status-monitor-service
      > web=0:Free



## Examples

    $https://APPNAME-status-monitor-service.herokuapp.com/request-dump

    $http://localhost:9000/request-dump


## License
See Creative Commons LICENSE included in the source directory.
Copyright © 2020 Jaret Binford

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
