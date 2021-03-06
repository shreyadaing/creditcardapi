# Credit Cards API

This is a RESTFul API for creating and retrieving credit card details. This RESTful API uses OpenAPI specification and has a swagger UI client to test the API endpoints. 
Its standard MAVEN based springboot application.

Two REST Endpoints implemented are:
1. GET : /api/credit-cards/.  (Retrieve all credit cards in the system)
2. POST: /api/credit-cards. (Add a new credit card for a given name, number and limit)

Validations:
o	Card numbers should be validated using Luhn 10
o	New cards start with a £0 balance
o	for cards not compatible with Luhn 10, return an error
•	"Get all" returns all cards in the system


# Pre-Requisites

This application needs Java 8 or higher to work on a developer machine. Please install one before you start.

# How to run the application?

1. In the project folder, run :

    #### ./mvnw clean package
 
 This will run the unit tests and on success, build a demo-0.0.1-SNAPSHOT.jar in the target folder.
 
 2. Run the jar from the Root folder:
 
  #### java -jar /target/demo-0.0.1-SNAPSHOT.jar
   
   or from the target folder:
   
 #### java -jar demo-0.0.1-SNAPSHOT.jar
   
   3. You can access the API from dev machine:
   
  ####  http://localhost:8083/swagger-ui.html
