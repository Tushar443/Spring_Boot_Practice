package com.example.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/")
	public String getHello() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String getLeaders() {
		return "leaders";
	}
	
	@GetMapping("/system")
	public String getSystem() {
		return "system";
	}
}
