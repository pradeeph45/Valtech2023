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

import com.valtech.training.springbootassignment.model.EmployeeModel;
import com.valtech.training.springbootassignment.services.EmployeeService;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/edit")
	public String editEmployee(@RequestParam("employeeId") long employeeId, Model model) {
		model.addAttribute("employees", new EmployeeModel(employeeService.getEmployee(employeeId)));
		return "employee/edit";
	}

	@PostMapping(path = "/save", params = "submit")
	public String saveEmployee(@ModelAttribute EmployeeModel employeeModel, Model model) {
		employeeService.createEmployee(employeeModel.getEmployee());
		model.addAttribute("employees",
				employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employee/list";
	}

	@PostMapping(path = "/save", params = "cancel")
	public String cancelEditEmployee(@ModelAttribute EmployeeModel employeeModel, Model model) {
		model.addAttribute("employees",
				employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employee/list";
	}

	@GetMapping("/new")
	public String newEmployee(Model model) {
		model.addAttribute("employees", new EmployeeModel());
		return "employee/edit";
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("employees",
				employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employee/list";

	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") long employeeId,Model model) {
		
		employeeService.deleteByEmployeeId(employeeId);
		model.addAttribute("employees",
				employeeService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		
		return "employee/list";
	}
}
