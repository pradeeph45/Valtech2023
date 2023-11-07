package com.valtech.training.hibernate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private int phone;
	@Embedded
	private RegAddress regAddress;

	public Registration(String username, String password, int phone, RegAddress regAddress) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.regAddress = regAddress;
	}

	public Registration() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public RegAddress getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(RegAddress regAddress) {
		this.regAddress = regAddress;
	}

}
