package com.valtech.training.springbootassignment.services;



import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.repositories.DepartmentRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	@PostConstruct
	public void populateDepartment() {
		departmentRepo.save(new Department("LV","Third Floor"));
		departmentRepo.save(new Department("Campus Training", "Terrace Training Room"));
		departmentRepo.save(new Department("Valtech Mobility","Pune"));
	}
	
	@Override
	public Department createDepartment(Department department) {
		return departmentRepo.save(department);
	}
	
	@Override
	public Department updateDepartment(Department department) {
		return departmentRepo.save(department);
	}
	
	@Override
	public Department getDepartment(Long departmentId) {
		return departmentRepo.getReferenceById(departmentId);
	}
	
	@Override
	public List<Department> getAllDepartments(){
		return departmentRepo.findAll();
		}
	
	@Override
	public void deleteDepartment(Long departmentId) {
		departmentRepo.deleteById(departmentId);
	}
}
