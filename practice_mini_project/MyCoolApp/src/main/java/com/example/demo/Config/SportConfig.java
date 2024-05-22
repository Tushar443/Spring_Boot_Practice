package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.common.SwimCoach;
import com.example.demo.service.demoInterface.Coach;

@Configuration
public class SportConfig {

	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
	
}
