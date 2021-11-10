package com.example.CountryNumbers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.CountryNumbers.entity.Customer;
import com.example.CountryNumbers.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> listCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/customersbycountry/{country}")
    public ResponseEntity<List<Customer>> getCustomersByCountry(@PathVariable("country") String country) {
        List<Customer> customers = customerService.getCustomersByCountry(country);
        return ResponseEntity.ok(customers);
    }

}