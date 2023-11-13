package com.valtech.training.firstspringboot.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.model.ChangePasswordModel;
import com.valtech.training.firstspringboot.model.RegisterUserModel;
import com.valtech.training.firstspringboot.service.AuthService;
import com.valtech.training.firstspringboot.service.AuthServiceImpl;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService; 
	
	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute ChangePasswordModel pwdModel,Model model) {
		pwdModel.setUsername(userDetails.getUsername());
		if(Objects.equals(pwdModel.getNewPassword(), pwdModel.getConfirmPassword())) {
			if(authService.changePassword(pwdModel)) {
				model.addAttribute("message","Password changed successfully");
				
			}
			else {
				model.addAttribute("message","Old Password doesn't match");
			}
		}else {
			model.addAttribute("message","Password and Confirm Password do not match");
			return "changePassword";
		}
		return "redirect:logout";
	}
	
	@GetMapping("/changePassword")
	public String changePassword() {
		return "changePassword";
	}

	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute RegisterUserModel registerUserModel,Model model) {
		if((registerUserModel.getPassword()).equals((registerUserModel.getConfirmPassword()))){
			authService.createUser(registerUserModel);
			model.addAttribute("message","User Registration successful.. pls proceed to login");
		}else {
			model.addAttribute("message","Password and Confirm Password do not match");
			return "register";
		}
		return "login";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/anon")
    @ResponseBody
	public String anonPage() {
	return "Anonymous Page";
}
    @GetMapping("/user")
    @ResponseBody
	public String userPage() {
	return "User Page";
}
    @GetMapping("/admin")
    @ResponseBody
	public String adminPage() {
	return "Admin Page";
}
    
}
