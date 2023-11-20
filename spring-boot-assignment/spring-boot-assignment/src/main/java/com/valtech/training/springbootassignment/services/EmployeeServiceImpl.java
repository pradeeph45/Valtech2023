package com.valtech.training.springbootassignment.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entities.Employee;
import com.valtech.training.springbootassignment.repositories.EmployeeRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
 @Autowired
 private EmployeeRepo employeeRepo;
 
 @Override
@PostConstruct
 public void populateEmployees() {
	 employeeRepo.save(new Employee("Pradeep", 25, 2, 6, 100000.00));
	 employeeRepo.save(new Employee("Rohit", 27, 4, 4, 200000.00));
	 employeeRepo.save(new Employee("Virat", 35, 10, 2, 300000.00));
 }
 
 @Override
public Employee createEmployee(Employee employee) {
	 return employeeRepo.save(employee);
 }
 
 @Override
public Employee updateEmployee(Employee employee) {
	return employeeRepo.save(employee); 
 }
 
 @Override
public Employee getEmployee(Long employeeId) {
	 return employeeRepo.getReferenceById(employeeId);
	 
 }
 
 @Override
public List<Employee> getAllEmployees(){
	 return employeeRepo.findAll();
 }
 @Override
 public void deleteByEmployeeId(Long employeeId) {
	 employeeRepo.deleteById(employeeId);
 }

}
