package com.microservices.microservices.controllers;

import com.microservices.microservices.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }
    @GetMapping("/user")
    public User getUser(){
        return new User("tushar@gmail.com","Tushar","pwd");
    }
}
