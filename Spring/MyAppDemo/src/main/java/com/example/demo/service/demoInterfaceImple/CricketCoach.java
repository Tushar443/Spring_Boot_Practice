package com.example.demo.service.demoInterfaceImple;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.service.demoInterface.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("Cricket coach constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Cricket coach is called";
	}

	@PostConstruct
	public void doMyStartUpWork() {
		System.out.println("my Startup work");
	}
	
	@PreDestroy
	public void doMyCleanUpWork() {
		System.out.println("my clean up work");
	}
	
}
