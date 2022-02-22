package com.example.assignment2.DataAccess.Repositories;

import com.example.assignment2.DataAccess.Database.ConnectionHelper;
import com.example.assignment2.DataAccess.Models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(-1);
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                exception.printStackTrace();
                System.exit(-1);
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
            System.out.println(e.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                exception.printStackTrace();
                System.exit(-1);
            }
        }

        return successfullyUpdated;
    }
}
