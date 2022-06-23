package com.example.keycloakspringbootadapter.repository;

import com.example.keycloakspringbootadapter.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
