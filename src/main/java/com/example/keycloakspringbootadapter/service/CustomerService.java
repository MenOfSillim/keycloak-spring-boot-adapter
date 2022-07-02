package com.example.keycloakspringbootadapter.service;

import com.example.keycloakspringbootadapter.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomers();
    List<Customer> findCustomers();
}
