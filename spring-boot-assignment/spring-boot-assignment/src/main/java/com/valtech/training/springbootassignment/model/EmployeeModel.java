package com.valtech.training.springbootassignment.model;

import com.valtech.training.springbootassignment.entities.Employee;

public class EmployeeModel {

	private long employeeId;
	private String employeeName;
	private int age;
	private int experience;
	private int seniority;
	private double salary;

	public EmployeeModel() {
	}

	public EmployeeModel(Employee e) {
		this.employeeId = e.getEmployeeId();
		this.employeeName = e.getEmployeeName();
		this.age = e.getAge();
		this.experience = e.getExperience();
		this.seniority = e.getSeniority();
		this.salary = e.getSalary();

	}

	public Employee getEmployee() {
		return new Employee(employeeId, employeeName, age, experience, seniority, salary);

	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
