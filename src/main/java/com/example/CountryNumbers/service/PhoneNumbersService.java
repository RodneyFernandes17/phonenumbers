package com.example.CountryNumbers.service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CountryNumbers.entity.PhoneNumbers;
import com.example.CountryNumbers.repository.PhoneNumbersRepository;

@Service
public class PhoneNumbersService {

	@Autowired
	private PhoneNumbersRepository phoneNumbersRepository;

	public List<PhoneNumbers> readPhoneNumbers() {
		return phoneNumbersRepository.findAll();
	}

	public List<PhoneNumbers> readPhoneNumbersByCountry(String country) {

		if (country.trim().equalsIgnoreCase("Cameroon")) {
			final String regex = "\\(237\\)\\ ?[2368]\\d{7,8}$";
			return phoneNumbersRepository.findAll().stream().filter(s -> s.getPhone().matches(regex))
					.collect(Collectors.toList());
		} else if (country.trim().equalsIgnoreCase("Ethiopia")) {
			final String regex = "\\(251\\)\\ ?[1-59]\\d{8}$";
			return phoneNumbersRepository.findAll().stream().filter(s -> s.getPhone().matches(regex))
					.collect(Collectors.toList());
		} else if (country.trim().equalsIgnoreCase("Morocco")) {
			final String regex = "\\(212\\)\\ ?[5-9]\\d{8}$";
			return phoneNumbersRepository.findAll().stream().filter(s -> s.getPhone().matches(regex))
					.collect(Collectors.toList());
		} else if (country.trim().equalsIgnoreCase("Mozambique")) {
			final String regex = "\\(258\\)\\ ?[28]\\d{7,8}$";
			return phoneNumbersRepository.findAll().stream().filter(s -> s.getPhone().matches(regex))
					.collect(Collectors.toList());
		} else if (country.trim().equalsIgnoreCase("Uganda")) {
			final String regex = "\\(256\\)\\ ?\\d{9}$";
			return phoneNumbersRepository.findAll().stream().filter(s -> s.getPhone().matches(regex))
					.collect(Collectors.toList());
		} else
			return null;

	}

}
