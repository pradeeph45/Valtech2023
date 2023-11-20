package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface CustomerDAO {

	void deleteCustomer(int id);

	void updateCustomer(Customer customer);

	void createCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomer();

	long countProduct();

}