package com.valtech.training.springbootassignment.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.springbootassignment.model.DepartmentModel;
import com.valtech.training.springbootassignment.model.EmployeeModel;
import com.valtech.training.springbootassignment.services.DepartmentService;
import com.valtech.training.springbootassignment.services.EmployeeService;

@Controller
@RequestMapping(path = "/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/edit")
	public String editDepartment(@RequestParam("departmentId") long departmentId, Model model) {
		model.addAttribute("departments", new DepartmentModel(departmentService.getDepartment(departmentId)));
		return "department/edit";
	}

	@PostMapping(path = "/save", params = "submit")
	public String saveDepartment(@ModelAttribute DepartmentModel departmentModel, Model model) {
		departmentService.createDepartment(departmentModel.getDepartment());
		model.addAttribute("departments",
				departmentService.getAllDepartments().stream().map(d -> new DepartmentModel(d)).collect(Collectors.toList()));
		return "department/list";
	}

	@PostMapping(path = "/save", params = "cancel")
	public String cancelEditDepartment(@ModelAttribute DepartmentModel departmentModel, Model model) {
		model.addAttribute("departments",
				departmentService.getAllDepartments().stream().map(d -> new DepartmentModel(d)).collect(Collectors.toList()));
		return "department/list";
	}

	@GetMapping("/new")
	public String newDepartment(Model model) {
		model.addAttribute("departments", new DepartmentModel());
		return "department/edit";
	}

	@GetMapping("/list")
	public String listDepartments(Model model) {
		model.addAttribute("departments",
				departmentService.getAllDepartments().stream().map(d -> new DepartmentModel(d)).collect(Collectors.toList()));
		return "department/list";

	}
	
	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam("departmentId") long departmentId,Model model) {
		
		departmentService.deleteDepartment(departmentId);
		model.addAttribute("departments",
				departmentService.getAllDepartments().stream().map(d -> new DepartmentModel(d)).collect(Collectors.toList()));
		
		return "department/list";
	}
}
