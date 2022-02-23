Assignment 2: JAVA Data Access & Display					By Timothy Blom
										And Wessel Konstantinov

Explained:
For this assignment, as we understand it, we need to use Java and Spring to make JDBC calls to
a Chinook SQL Lite database with a list of customers and their information, and make multable calls that 
edit the list and return a filtered list.
We also need to make a home page with Thymeleaf that displayes songs from the same Chinook SQL Lite 
database, where it displayes a random list of songs and contains a search bar. 
We are also to provide a collection of API calls in JSON format made in POSTMAN.
Lastly, we are to publish this application as a Docker container on Heroku.

Customers have the following information:
-ID
-First name
-Last name
-Country
-Postal code
-Phone number
-Email adress

Customer calls include:
-One specific customer with all its information, called from by ID or name
-Adding a new customer
-Updating/changing information from a customer
-Return the number of customers per country, from low to high.
-Return a list of customers filtered by who spent the most money, from high to low
-For a specific customer its favorite genre, based on the amount of money spent per genre.
-Return a page of customers from the database. This should take in limit and offset as parameters and make use 
of the SQL keywords to get a subset of the customer data. The customer model from above should be reused.
i.e. 10 customers starting at 50 (customers 50-60).

Notes to self:
Configure REST endpoints with Spring?

We are to inplement the repository pattern for this assignment, what does that mean?

Endpoint must be on a /api/ sub directory in the application structure, so "/" and
"/search?term=foo" are for the thymeleaf pages and "/api/bar" is for the REST endpoint.
Endpoints must be named with nouns, not verbs.

You should create a class (model) for each data structure you intend to use. Do not return a formatted string/tuple.
This is a minimum of: Customer, CustomerCountry, CustomerSpender, CustomerGenre. Place these classes in a Models 
Package inside your Data Access package