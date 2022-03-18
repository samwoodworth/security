# Spring Boot Authentication Service

## Introduction
This is the authentication service for the application, with the goal being to compare the framework against others.
Spring Security is used for authentication. H2 database is used to store the user information.

## Technologies
Java 17.0.1\
Spring Boot 2.6.1

## Running the application
The application can be run using 'mvn spring-boot:run' from the 'security' directory and can be reached at 'localhost:8080/'.

## Usage
Log in with either the 'user' or 'admin' username, where the password for both is 'pass'. From there, there is a link to the API home page and a button to sign out.

### Authentication
The application uses the Spring Security framework to handle authentication. The '/home' endpoint
is secured until the user is logged in. Spring Security also handles logging out.