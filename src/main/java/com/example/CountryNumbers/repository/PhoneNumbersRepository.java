package com.example.CountryNumbers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CountryNumbers.entity.PhoneNumbers;

@Repository
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers, Integer> {

	public boolean existsByCountry(String country);

	public boolean existsByState(String state);

	public List<PhoneNumbers> findByCountry(String country);

	public List<PhoneNumbers> findByState(String state);

}
