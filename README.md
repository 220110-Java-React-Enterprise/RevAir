# Project 1

Team G: RevAir

## Contributors
Jeremiah Smith, Ibrahima Diallo, Christopher Jones

## Description
This web service allows users to create, modify and delete their own airline tickets, as well as the flights themselves. A custom ORM is used to persist the data.

## Tech Stack
  - Tomcat
  - Java 8
  - Custom ORM
  - Apache Maven
  - Amazon Web Services RDS
  - MariaDB
  - Git/Github
  - Postman
  
## Project 1

Build an API (Application Programming Interface) that show functionality and store objects in a database that are remotely accessible via Postman. This API will depend on the ORM where the webapp functionalities are accessible through the dependencies. This API is designed for flights where the user can access tickets information, check for the departure and destination location by using the read, update, and delete (CRUD) requests as they want.

## Part 1: Custom ORM

Utilizing Apache Maven, Java 8 and MariaDB, our ORM is able to dissect an object using reflection and annotations to produce a schema of tables that share the characteristics of the given object. Packaged as a dependency, it is later used by the web app to persists and retrieve data from a AWS hosted database.

## Part 2: Web App (Web Servives)

Use Postman as the front-end interface, the airline tickets is remotely available on AWS and uses the custom ORM as a dependecy to create tables and objects on MariaDB. Java Servlets allow the webapp to store, manipulate, and retrieve objects as request.

## Minimum Requirements

- Proper use of OOP principles
- CRUD operations are supported for at least 2 types of objects.
- Communication is done with HTTP exchanges, and resources are transmitted as JSON in request/response bodies.
- JDBC and persistence logic should all be part of your ORM which abstracts this away from the rest of the application.
- Documentation (all classes and methods have adequate Javadoc comments)
- All Exceptions are caught and logged to a file

## Bonus Features

ORM can build foreign key relations according o object references.
ORM can design schema on the fly

## Minimum Viable Product

- As a user, I store JSON objects by invoking the proper endpoint (POST/Create).
- As a user, I can change objects by invoking the proper endpoint (PUT/Update).
- As a user, I can retrieve objects by invoking the proper endpoint (GET/Read).
- As a user, I can delete objects by invoking the proper endpoint (DELETE/Delete).
- As a user, I can retrieve all objects that belong to me (transmit the user as part of the request header, and build a relation in the database 
  in some way to tie the objects to the user).





