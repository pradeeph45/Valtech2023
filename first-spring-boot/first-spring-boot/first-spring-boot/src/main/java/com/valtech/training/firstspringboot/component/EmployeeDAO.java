package com.valtech.training.firstspringboot.component;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	public long count ();

	void deleteEmployee(int id);

	void updateEmployee(Employee emp);

	void createEmployee(Employee emp);

	List<Employee> getAllEmployee();

	Employee getEmployee(int id);

}