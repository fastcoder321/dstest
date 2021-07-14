
# Test solution

## How to run via a cmd shell (eg gitbash):

1. To start, run this command: ./gradlew bootRun
2. To stop, run this in another shell: ./gradlew -stop

## How to connect to the endpoints:

Since this is an http GET endpoint, you can simply go to the url in a web browser:
1. http://localhost:8080/allusers

Note I created some additional endpoints that are pass-through calls to the 'source' endpoints:
1. http://localhost:8080/unregistered
2. http://localhost:8080/registered
3. http://localhost:8080/projectmemberships

## How to install the code:

There is really nothing to install. Gradle will download the dependencies and startup spring boot.

