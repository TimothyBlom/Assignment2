Assignment 2: JAVA Data Access & Display					By Timothy Blom
										And ...
This assignment is done in groups of 2. 

To Do:
Access the provited Chinook SQL Lite database through JDBC, ERDs are provited.
Create a Spring Boot Web API, add the SQL Lite JDBC dependency and create classes 
to interact with the database.

Endpoint must be on a /api/ sub directory in the application structure, so "/" and
"/search?term=foo" are for the thymeleaf pages and "/api/bar" is for the REST endpoint.
Endpoints must be named with nouns, not verbs.
Must provide a collection of API calls made in Postman to test endpoints by creating a 
collection and exporting it as JSON.

Costumer requirements (what does that mean? a Json of all costumers?)
Costumer must have a ID, first and last name, country, postal code, phone nr. and email.
Read a specific costumer from database by ID or by name and display all its info.
return a page of costumers from database, should take in limit and offset as paramaters and
use SQL keywords to get subset of costumer data.
add new costumer.
update existing costumer.
return number of each costumer per country, from low to high.
return costumers who spent the most money, total in invoice table is the largest (whatever that means).
for a given costumer its favorite genre, seen by most tracks from invoice.
(Given hint: You should be looking to use some of the following SQL clauses: JOINs, ORDERBY, GROUPBY, and MAX.)

Implement repository pattern, the version doesn't matter.
(Given hint: Consult the provided material for examples of the Repository pattern. You can 
place the Repositories package in a Data Access package alongside your models)

Add Thymeleaf to project to create several views
-Home page, with 5 ramdom artists, songs and genres, a search bar that can't be empty.
-The search results page shows the user query, underneath the results in a row with song info,  it
should also be case insensitive.




Step one, figure out what the following means:
-Chinook SQL Lite database
-JDBC
-ERDs
-Spring Boot Web API

-Endpoint
-REST endpoint
-API calls made in Postman
-Repository pattern

-Thymeleaf
-Docker container
-Heroku