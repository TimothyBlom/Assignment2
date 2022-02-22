package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.Customer;
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
}