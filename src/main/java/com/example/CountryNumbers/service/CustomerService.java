package com.example.CountryNumbers.service;



import java.util.List;

import com.example.CountryNumbers.entity.Customer;

public interface CustomerService {
    List<Customer> getCustomers();
    List<Customer> getCustomersByCountry(String country);
}
