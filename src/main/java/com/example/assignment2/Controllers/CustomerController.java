package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.Customer;
import com.example.assignment2.DataAccess.Models.CustomerCountry;
import com.example.assignment2.DataAccess.Models.CustomerGenre;
import com.example.assignment2.DataAccess.Models.CustomerSpender;
import com.example.assignment2.DataAccess.Repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.getCustomerById(id);
    }

    @GetMapping("/search")
    public Customer getCustomerByName(@RequestParam String name) {
        return customerRepository.getCustomerByName(name);
    }

    @GetMapping("/page")
    public ArrayList<Customer> getPageOfCustomers(@RequestParam String limit, @RequestParam String offset) {
        return customerRepository.getPageOfCustomers(limit, offset);
    }

    @PostMapping
    public boolean addNewCustomer(@RequestBody Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public boolean updateExistingCustomer(@PathVariable String id, @RequestBody Customer customer) {
        customer.setCustomerId(id);
        return customerRepository.updateCustomer(customer);
    }

    @GetMapping("/countries")
    public ArrayList<CustomerCountry> getCountriesByCustomerCount() {
        return customerRepository.getCountriesByCustomerCount();
    }

    @GetMapping("/top/spenders")
    public ArrayList<CustomerSpender> getCustomersByTotalSpending() {
        return customerRepository.getCustomersByTotalSpending();
    }

    @GetMapping("/{id}/popular/genre")
    public ArrayList<CustomerGenre> getMostPopularGenresPerCustomer(@PathVariable String id) {
        return customerRepository.getMostPopularGenresPerCustomer(id);
    }
}