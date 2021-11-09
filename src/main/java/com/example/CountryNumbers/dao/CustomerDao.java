package com.example.CountryNumbers.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.CountryNumbers.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDao {

	JdbcTemplate jdbcTemplate;

	private static String GET_COSTUMERS = "SELECT * FROM customer";

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Customer> listAllCustomers() {
		List<Customer> pn = jdbcTemplate.query(GET_COSTUMERS, new BeanPropertyRowMapper(Customer.class));
		return pn;
	}

	public List<Customer> listCustomersByCountry(String country) {

		List<Customer> pn = jdbcTemplate.query(GET_COSTUMERS, new BeanPropertyRowMapper(Customer.class));

		if (country.trim().equalsIgnoreCase("Cameroon")) 
			return pn.stream().filter(s -> s.getPhone().matches("\\(237\\)\\ ?[2368]\\d{7,8}$"))
					.collect(Collectors.toList());			
		else if (country.trim().equalsIgnoreCase("Ethiopia"))
			return pn.stream().filter(s -> s.getPhone().matches("\\(251\\)\\ ?[1-59]\\d{8}$"))
					.collect(Collectors.toList());
		else if (country.trim().equalsIgnoreCase("Morocco"))
			return pn.stream().filter(s -> s.getPhone().matches("\\(212\\)\\ ?[5-9]\\d{8}$"))
					.collect(Collectors.toList());
		else if (country.trim().equalsIgnoreCase("Mozambique"))
			return pn.stream().filter(s -> s.getPhone().matches("\\(258\\)\\ ?[28]\\d{7,8}$"))
					.collect(Collectors.toList());
		else if (country.trim().equalsIgnoreCase("Uganda"))
			return pn.stream().filter(s -> s.getPhone().matches("\\(256\\)\\ ?\\d{9}$")).collect(Collectors.toList());
		else
			return null;

	}
}