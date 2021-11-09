package com.example.CountryNumbers.entity;

import javax.persistence.*;

@Entity
public class Customer {

	@Id
	private int id;
	private String name;
	private String phone;

	public Customer() {
	}

	public Customer(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}