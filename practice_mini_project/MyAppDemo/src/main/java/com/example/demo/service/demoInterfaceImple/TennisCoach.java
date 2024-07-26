package com.example.demo.service.demoInterfaceImple;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.service.demoInterface.Coach;

@Component
@Lazy
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println("Tennis coach constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Tennis coach is called";
	}

}
