package com.example.CountryNumbers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CountryNumbers.entity.PhoneNumbers;
import com.example.CountryNumbers.service.PhoneNumbersService;

@RestController
@RequestMapping("/numbers")
public class PhoneNumbersController {

	@Autowired
	private PhoneNumbersService phoneNumbersService;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "Test App Phone Numbers";
	}

	@RequestMapping(value = "/readAllNumbers", method = RequestMethod.GET)
	public List<PhoneNumbers> readAllNumbers() {
		return phoneNumbersService.readPhoneNumbers();
	}

	@RequestMapping(value = "/readNumbersByCountry", method = RequestMethod.GET)
	public List<PhoneNumbers> readNumbersByCountry(@RequestBody String country) {
		return phoneNumbersService.readPhoneNumbersByCountry(country);
	}

}
