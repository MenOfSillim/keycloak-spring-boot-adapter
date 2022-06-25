package com.example.keycloakspringbootadapter.service;

import com.example.keycloakspringbootadapter.entity.Customer;
import com.example.keycloakspringbootadapter.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void addCustomers() {
        Customer customer1 = Customer.builder()
                .address("1111 foo bivd")
                .name("Foo Foo")
                .serviceRendered("Important service")
                .build();
        customerRepository.save(customer1);

        Customer customer2 = Customer.builder()
                .address("2222 bar bivd")
                .name("Bar bar")
                .serviceRendered("Important service")
                .build();
        customerRepository.save(customer2);

        Customer customer3 = Customer.builder()
                .address("3333 main bivd")
                .name("Main page")
                .serviceRendered("Important service")
                .build();
        customerRepository.save(customer3);
    }

    @Override
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }
}
