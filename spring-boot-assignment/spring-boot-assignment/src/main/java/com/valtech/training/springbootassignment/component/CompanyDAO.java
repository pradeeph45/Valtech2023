package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface CompanyDAO {
	public String hello();

	void deleteCompany(int id);

	void updateCompany(Company company);

	void createCompany(Company company);

	List<Company> getAllCompany();

	Company getCompany();

	long countCompany();

}