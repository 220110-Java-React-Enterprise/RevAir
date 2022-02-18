# RevAir
Project 1 Team G

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

## Contributors
Jeremiah Smith, Ibrahima Diallo, Christopher Jones

===============================================================

Project 1:
By: David Alvarado, Maja Wirkijowska

Description:
Tech Stack:
HTTP
ORM (custom made for data persistance)
Servlets
Java 8
AWS
Apache Maven for dependencies and project management
Git & Github for version control
MariaDB RDS for data persistance
Tomcat server
Postman
Project 1
Part 1: Custom ORM
Using Apache Maven and Java 8 and MariaDB, the ORM is able to dissect an object using reflection and annotations to produce a schema of tables that share the characteristics of the given objects. Packaged as a dependency, it is later used by the web app to persists and retrieve data from a AWS hosted database.

Part 2: Web App
Using Postman as the front-end interface, the ticket kiosk is remotely available on AWS and uses the Part 1: Customer ORM as a dependecy to create tables and objects on MariaDB. Java Servlets allow the web-app to store, manipulate, and retrieve objects in response to HTTP requests.

Minimum Requiremnets:
Proper use of OOP principles
CRUD operations are supported for at least 2 types of objects.
Communication is done with HTTP exchanges, and resources are transmitted as JSON in request/response bodies.
JDBC and persistence logic should all be part of your ORM which abstracts this away from the rest of the application.
Documentation (all classes and methods have adequate Javadoc comments)
All Exceptions are caught and logged to a file
Bonus Features
ORM can build foreign key relations according o object references.
ORM can design schema on the fly
User Stories
As a user, I store JSON objects by invoking the proper endpoint (POST/Create).
As a user, I can change objects by invoking the proper endpoint (PUT/Update).
As a user, I can retrieve objects by invoking the proper endpoint (GET/Read).
As a user, I can delete objects by invoking the proper endpoint (DELETE/Delete).
As a user, I can retrieve all objects that belong to me. (transmit the user as part of the request header, and build a relation in the database in some way to tie the objects to the user)


