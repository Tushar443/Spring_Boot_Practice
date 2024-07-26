package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.demoInterface.Coach;

@RestController
public class DemoController {
	public Coach coach;
	
	//constructor Injection
	public DemoController(@Qualifier("swimCoach") Coach coach) {
		System.out.println("In constructor :- "+getClass().getSimpleName());
		this.coach=coach;
		
	}

	@GetMapping
	public String Hello() {
		return "Hello World Coach Name :- ";
	}
	
	@GetMapping("getCoach")
	public String getCoach() {
		return coach.getDailyWorkout();
	}
	
}
