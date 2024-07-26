package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.demoInterface.Coach;

@RestController
public class DemoController {
	//Feild Injection not Recommonded
//	@Autowired
//	Coach coach;
	
	
	public Coach coach;
	public Coach anotherCoach;
	
	//constructor Injection
	public DemoController(@Qualifier("cricketCoach") Coach coach
			,@Qualifier("cricketCoach")Coach anotherCoach) {
		System.out.println("In consstructor :- "+getClass().getSimpleName());
		this.coach=coach;
		this.anotherCoach=anotherCoach;
		
	}
	
//	@Value("${coach.name}")
//	public String coachName;
//	
//	@Value("${team.name}")
//	public String teamName;
	
	@GetMapping
	public String Hello() {
		return "Hello World Coach Name :- ";
	}
	
	@GetMapping("getCoach")
	public String getCoach() {
		return coach.getDailyWorkout();
	}
	
	@GetMapping("/check")
	public String check() {
		return "comparing beans : "+ (this.coach==this.anotherCoach);
		
	}
	
	
}
