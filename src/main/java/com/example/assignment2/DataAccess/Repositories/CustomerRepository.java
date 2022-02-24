package com.example.assignment2.DataAccess.Repositories;

import com.example.assignment2.DataAccess.Database.ConnectionHelper;
import com.example.assignment2.DataAccess.Models.Customer;
import com.example.assignment2.DataAccess.Models.CustomerCountry;
import com.example.assignment2.DataAccess.Models.CustomerGenre;
import com.example.assignment2.DataAccess.Models.CustomerSpender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//Collects all customers and their information from the SQLite database
public class CustomerRepository {
    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getString("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customers;
    }

    public Customer getCustomerById(String customerId) {
        Customer customer = null;
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer";
            selectQuery += " WHERE CustomerId = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customer;
    }

    public Customer getCustomerByName(String name) {
        Customer customer = null;
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer";
            selectQuery += " WHERE FirstName LIKE ? OR LastName LIKE ?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getString("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(-1);
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                exception.printStackTrace();
                System.exit(-1);
            }
        }
        return customer;
    }

    public ArrayList<Customer> getPageOfCustomers(String limit, String offset) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer";
            selectQuery += " LIMIT ? OFFSET ?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, limit);
            preparedStatement.setString(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getString("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customers;
    }

    public boolean addCustomer(Customer customer) {
        Boolean successfullyAdded = false;
        try {
            conn = DriverManager.getConnection(URL);
            String createQuery = "INSERT INTO Customer (FirstName, LastName, Country, PostalCode, Phone, Email)";
            createQuery += " VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(createQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getCountry());
            preparedStatement.setString(4, customer.getPostalCode());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());

            int result = preparedStatement.executeUpdate();
            successfullyAdded = (result != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return successfullyAdded;
    }

    public boolean updateCustomer(Customer customer) {
        boolean successfullyUpdated = false;
        try {
            conn = DriverManager.getConnection(URL);
            String updateQuery = "UPDATE Customer SET FirstName = ?, LastName = ?, Country = ?, PostalCode = ?, Phone = ?, Email = ?";
            updateQuery += " WHERE CustomerId = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getCountry());
            preparedStatement.setString(4, customer.getPostalCode());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getCustomerId());

            int result = preparedStatement.executeUpdate();
            successfullyUpdated = (result != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return successfullyUpdated;
    }

    public ArrayList<CustomerCountry> getCountriesByCustomerCount() {
        ArrayList<CustomerCountry> countriesByCustomerCount = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT Country, COUNT(*) AS CustomerCount FROM Customer";
            selectQuery += " GROUP BY Country ORDER BY CustomerCount DESC";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                countriesByCustomerCount.add(
                        new CustomerCountry(
                                resultSet.getString("Country"),
                                resultSet.getString("CustomerCount")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return countriesByCustomerCount;
    }

    public ArrayList<CustomerSpender> getCustomersByTotalSpending() {
        ArrayList<CustomerSpender> customersByTotalSpending = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT C.CustomerId, C.FirstName, C.LastName, C.Country, C.PostalCode, C.Phone, C.Email, SUM(I.Total) AS TotalSpending";
            selectQuery += " FROM Customer C INNER JOIN Invoice I ON I.CustomerId = C.CustomerId GROUP BY C.CustomerId ORDER BY TotalSpending DESC";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customersByTotalSpending.add(
                        new CustomerSpender(
                                resultSet.getString("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email"),
                                resultSet.getString("TotalSpending")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customersByTotalSpending;
    }

    public ArrayList<CustomerGenre> getMostPopularGenresPerCustomer(String customerId) {
        ArrayList<CustomerGenre> mostPopularGenres = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "WITH PopularGenre AS (SELECT C.CustomerId, C.FirstName, C.LastName, G.Name, COUNT(Il.Quantity) as TotalScore";
            selectQuery += " FROM Customer C INNER JOIN Invoice I ON I.CustomerId = C.CustomerId INNER JOIN InvoiceLine Il ON I.InvoiceId = Il.InvoiceId";
            selectQuery += " INNER JOIN Track T ON T.TrackId = Il.TrackId INNER JOIN Genre G ON T.GenreId = G.GenreId  WHERE C.CustomerId = ? GROUP BY G.Name)";
            selectQuery += " SELECT PG.CustomerId, PG.FirstName, PG.LastName, PG.Name, TotalScore FROM PopularGenre  PG";
            selectQuery += " GROUP BY PG.Name HAVING TotalScore = (SELECT MAX(TotalScore) FROM PopularGenre);";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                mostPopularGenres.add(
                        new CustomerGenre(
                                resultSet.getString("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Name")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mostPopularGenres;
    }
}
