# Demo
A Spring Boot Application [Spring Initializr](https://start.spring.io/) for show casing a demo Web Application, that exposes a REST API.

Usage
* This Web App exposes a REST API, that takes in a list of emails ( as a JSON array ), and returns a JSON mapping of Unique NORMALIZED emails to a count.
* Where "unique" email addresses means they will be delivered to the same account using Gmail account matching. Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".
* Normalized email addr is defined as an email without the "." in the username, and excludes any part after "+".
* Invalid emails or emails not ending in "@gmail.com" are excluded from the response.

API
* API endpoint is : POST  http://localhost:8080/demo/api/v1/gmails/uniqueCount. 
* JSON input payload ( example ) is defined as :
{
  "emails": [
    "test1@gmail.com", "test1+@gmail.com"
  ]
}
* JSON response ( example ) is defined as :
{
  "emailsCount": {
    "test1@gmail.com": 1
  }
}
* Example curl command is :
curl -X POST "http://localhost:8080/demo/api/v1/gmails/uniqueCount" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"emails\": [ \"user@gmail.com\", \"u.ser@gmail.com\", \"user+xyz@gmail.com\" ]}"

* Swagger API documentation is available at endpoint : http://localhost:8080/demo/swagger-ui.html ( Resource name is 'email-count-resource')

HealthCheck.
* To check if the service is available and running use : http://localhost:8080/demo/health
    
Installation.
* Using docker : cd to the demo directory, and build the image using : "docker build -t demo .".
To run in a docker container, use : "docker run -p 8080:8080 demo"

* Using gradle : cd to the the demo directory, and then to build use "./gradlew clean build".
To run the Web App use "./gradlew bootRun"
