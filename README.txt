Assignment 2: JAVA Data Access & Display					By Timothy Blom
										And Wessel Konstantinov

Assignment explained:
For this assignment, as we understand it, we need to use Java and Spring to make JDBC calls to
a Chinook SQL Lite database with a list of customers and their information, and make multiple calls that 
edit the list and return a filtered list.
We also need to make a home page with Thymeleaf that displays songs from the same Chinook SQL Lite 
database, where it displays a random list of 5 songs, 5 artists and 5 genres. It aso contains a search 
bar where the user can search for a specific inquiry.
We are also to provide a collection of API calls in JSON format made in POSTMAN.
Lastly, we are to publish this application as a Docker container on Heroku.

Result:
All Java functions are working as described
A thymeleaf page with all requirements is working
A list with Postman calls can be found here: https://documenter.getpostman.com/view/14739320/UVkpMaYP
The application has been put in a container with Docker and published on Heroku: https://assignment2-tim-wessel.herokuapp.com

(Customers have the following information: ID, first and last name, country, postal code, phone nr. and email)

To test the functionality of this application, run it, open the browser and go to:
-localhost:8080/api/customers for a list of 60 costumers with their information
-localhost:8080/api/customer/1 for the customer with their information whose ID equals 1, and can go up to 60
-localhost:8080/api/customers/countries for a list of how many customers there are per country 
-localhost:8080/api/customers/top/spenders for the list starting with the highest spenders on top
-localhost:8080/api/customers/1/popular/genre for the customer selected by ID and their most favorite genre
-localhost:8080/api/customers/page for a list of 10 customers starting with ID nr. 50
-localhost:8080/api/customers/search for the customer with their information with the same name