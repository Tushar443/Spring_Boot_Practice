package com.example.demo.common;


import com.example.demo.service.demoInterface.Coach;


public class SwimCoach implements Coach{

	public SwimCoach() {
		System.out.println("Swim Coach Constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Swim Coach get swim 200 miles";
	}
	
	

}
