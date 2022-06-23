package com.example.keycloakspringbootadapter.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String serviceRendered;
    private String address;

    @Builder
    public Customer(long id, String name, String serviceRendered, String address) {
        this.id = id;
        this.name = name;
        this.serviceRendered = serviceRendered;
        this.address = address;
    }
}
