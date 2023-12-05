package com.example.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LogInControllers {

	@GetMapping("/showMyLogInPage")
	public String showMyLoginPage() {
		return "plain-login";
	}
	
	@GetMapping("/access-denied")
	public String returnAccessDenied() {
		return "access-denied";
	}
	
	
	
}
