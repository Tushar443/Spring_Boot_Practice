package com.example.demo.service.demoInterfaceImple;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.service.demoInterface.Coach;
@Component
@Lazy
public class BaseBallCoach implements Coach {

	public BaseBallCoach() {
		System.out.println("BaseBall coach constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "BaseBall coach is called";
	}

}
