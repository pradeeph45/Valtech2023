package com.valtech.training.springbootassignment.model;

import com.valtech.training.springbootassignment.entities.Department;

public class DepartmentModel {
 
	private long departmentId;
	private String departmentName;
	private String departmentLocation;
	public DepartmentModel(Department department) {
		this.departmentId=department.getDepartmentId();
		this.departmentName=department.getDepartmentName();
	    this.departmentLocation=department.getDepartmentLocation();	
	}
	public DepartmentModel() {
		
	}
	public Department getDepartment() {
		return new Department(departmentId,departmentName, departmentLocation);
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	
	
}
