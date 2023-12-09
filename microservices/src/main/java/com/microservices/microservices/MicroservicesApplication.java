package com.microservices.microservices;

import com.microservices.microservices.dao.ToDoDao;
import com.microservices.microservices.dao.UserDao;
import com.microservices.microservices.entity.ToDo;
import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;
@Log
@SpringBootApplication
public class MicroservicesApplication implements CommandLineRunner{
	@Autowired
	UserDao userDao;
	@Autowired
	ToDoDao toDoDao;
	//simply add annotation
	//private static final Logger log = (Logger) LoggerFactory.getLogger(MicroservicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("hello lets fill h2 data base");

		log.info("finish database");
	}
}
