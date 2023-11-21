package com.valtech.training.springbootassignment.services;

import java.util.List;

import javax.annotation.PostConstruct;

import com.valtech.training.springbootassignment.entities.Department;

public interface DepartmentService {

	void populateDepartment();

	Department createDepartment(Department department);

	Department updateDepartment(Department department);

	Department getDepartment(Long departmentId);

	List<Department> getAllDepartments();

	void deleteDepartment(Long departmentId);

}