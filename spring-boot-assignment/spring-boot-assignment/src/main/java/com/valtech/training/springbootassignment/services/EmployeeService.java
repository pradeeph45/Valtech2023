package com.valtech.training.springbootassignment.services;

import java.util.List;

import javax.annotation.PostConstruct;

import com.valtech.training.springbootassignment.entities.Employee;

public interface EmployeeService {

	void populateEmployees();

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee getEmployee(Long employeeId);

	List<Employee> getAllEmployees();

	void deleteByEmployeeId(Long employeeId);

}