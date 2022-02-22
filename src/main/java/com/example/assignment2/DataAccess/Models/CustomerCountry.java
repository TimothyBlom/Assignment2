package com.example.assignment2.DataAccess.Models;

public class CustomerCountry {
    private String name;
    private String customerCount;


    public CustomerCountry(String name, String customerCount) {
        this.name = name;
        this.customerCount = customerCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(String customerCount) {
        this.customerCount = customerCount;
    }
}
