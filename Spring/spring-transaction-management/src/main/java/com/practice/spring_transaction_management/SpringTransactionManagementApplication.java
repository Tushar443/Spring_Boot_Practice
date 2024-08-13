package com.practice.spring_transaction_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringTransactionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionManagementApplication.class, args);
	}

}
