# Java Spring Boot Craft Demo

This is simple RESTful service built using Java 1.8, Spring Boot 1.5.8 and Maven 3 for a Twitter like solution.

## Database
This service uses in-memory database (H2) to store the data. Default username is 'sa' with a blank password. Script file data.sql used to load the sample data available in resources of this project. Database console is configured on:

http://localhost:8085/console

## How to Run

### Building project
```mvn clean package```

### Run test
```mvn test```

### Deploy
```java -jar target/java-craft-demo-1-SNAPSHOT.jar```

or

```mvn spring-boot:run```


## Endpoints

```
http://localhost:8085/feed
http://localhost:8085/users

```
### Curl to Retrieve list of feeds for logged in user 
```
curl -v -H "user:john@email.com" localhost:8085/feed
```
For simplicity collecting username or email address from header

### Curl for creating user
```
curl -X POST -v -H "content-type:application/json" -d '{"email":"test@email.com", "firstName":"John", "lastName":"Doe"}' http://localhost:8085/users
```
