package com.example.keycloakspringbootadapter.controller;

import com.example.keycloakspringbootadapter.entity.Customer;
import com.example.keycloakspringbootadapter.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final CustomerService customerService;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        customerService.addCustomers();
        Iterable<Customer> customers = customerService.findCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());

        return "customers";
    }
}
