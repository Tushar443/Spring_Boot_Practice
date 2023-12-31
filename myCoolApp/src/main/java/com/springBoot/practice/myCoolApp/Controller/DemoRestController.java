package com.springBoot.practice.myCoolApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/")
	public String SayHello() {
		return "Hello World";
	}
	
	
}
