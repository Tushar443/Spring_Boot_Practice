package com.microservices.microservices;

import com.microservices.microservices.dao.ToDoDao;
import com.microservices.microservices.dao.UserDao;
import com.microservices.microservices.entity.ToDo;
import com.microservices.microservices.entity.User;
import com.microservices.microservices.utilities.EncryptionUtils;
import lombok.Data;
import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.logging.Logger;

@Log
@SpringBootApplication
public class MicroservicesApplication implements CommandLineRunner {
    @Autowired
    UserDao userDao;
    @Autowired
    ToDoDao toDoDao;

    @Autowired
    EncryptionUtils encryptionUtils;
    //simply add annotation
    //private static final Logger log = (Logger) LoggerFactory.getLogger(MicroservicesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("hello lets fill h2 data base");
        String encryptPwd;
        encryptPwd = encryptionUtils.encrypt("hello");
        userDao.save(new User("alexa@gmail.com", "alexa chaturvedi", encryptPwd));

        encryptPwd = encryptionUtils.encrypt("hello2");
        userDao.save(new User("franz@gmail.com", "franz vadiya", encryptPwd));

        encryptPwd = encryptionUtils.encrypt("hello3");
        userDao.save(new User("annabel@gmail.com", "annabel pawar", encryptPwd));

        toDoDao.save(new ToDo(1, "learn microservice", new Date(), "high", "alexa@gmail.com"));
        toDoDao.save(new ToDo(1, "learn spring boot", null, "low", "alexa@gmail.com"));

        toDoDao.save(new ToDo(1, "feed animals", new Date(), "high", "franz@gmail.com"));
        toDoDao.save(new ToDo(1, "go to take jim", null, "low", "franz@gmail.com"));

        toDoDao.save(new ToDo(1, "By a new Car", new Date(), "high", "annabel@gmail.com"));
        toDoDao.save(new ToDo(1, "Go to the Gim", null, "low", "annabel@gmail.com"));

		log.info("finish database");
	}
}
