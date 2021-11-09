package com.example.CountryNumbers.service;


import org.springframework.stereotype.Service;

import com.example.CountryNumbers.dao.CustomerDao;
import com.example.CountryNumbers.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = customerDao.listAllCustomers();
        return customers;
    }

	@Override
	public List<Customer> getCustomersByCountry(String country) {
		List<Customer> customers = customerDao.listCustomersByCountry(country);
		return customers;
	}

}
