package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.example.demo",
				"com.example.Utils"
		}
		)
public class MyAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppDemoApplication.class, args);
	}
}
