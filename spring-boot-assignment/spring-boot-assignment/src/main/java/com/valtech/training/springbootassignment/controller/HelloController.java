package com.valtech.training.springbootassignment.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ComponentScan(basePackages = "com.valtech.training.springbootassignment")
public class HelloController {

	@GetMapping("/index")
	public String hello() {
		return "index";
	}
}
