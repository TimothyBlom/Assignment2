package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.*;
import com.example.assignment2.DataAccess.Repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository customerRepository = new CustomerRepository();

//Displays all customers with their information
    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

//Displays one customer with their information based on selected ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.getCustomerById(id);
    }

//Displays one customer with their information based on selected name
    @GetMapping("/search")
    public Customer getCustomerByName(@RequestParam String name) {
        return customerRepository.getCustomerByName(name);
    }

//Displays a page of 10 customers with their information
    @GetMapping("/page")
    public ArrayList<Customer> getPageOfCustomers(@RequestParam String limit, @RequestParam String offset) {
        return customerRepository.getPageOfCustomers(limit, offset);
    }

//Adds a customer
    @PostMapping
    public boolean addNewCustomer(@RequestBody Customer customer) {
        return customerRepository.addCustomer(customer);
    }

//Changes the values/information of a customer
    @PutMapping("/{id}")
    public boolean updateExistingCustomer(@PathVariable String id, @RequestBody Customer customer) {
        customer.setCustomerId(id);
        return customerRepository.updateCustomer(customer);
    }

//Displays all countries and how many customers they have
    @GetMapping("/countries")
    public ArrayList<CustomerCountry> getCountriesByCustomerCount() {
        return customerRepository.getCountriesByCustomerCount();
    }

//Displays all customers with the highest spenders on top
    @GetMapping("/top/spenders")
    public ArrayList<CustomerSpender> getCustomersByTotalSpending() {
        return customerRepository.getCustomersByTotalSpending();
    }

//Displays one customer selected by ID with their favorite genre
    @GetMapping("/{id}/popular/genre")
    public ArrayList<CustomerGenre> getMostPopularGenresPerCustomer(@PathVariable String id) {
        return customerRepository.getMostPopularGenresPerCustomer(id);
    }
}