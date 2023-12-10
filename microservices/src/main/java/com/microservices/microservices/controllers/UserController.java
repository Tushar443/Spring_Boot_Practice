package com.microservices.microservices.controllers;

import com.microservices.microservices.entity.ToDo;
import com.microservices.microservices.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("toDo")
    public String todoInput(@Validated ToDo todo){
        return "ToDo Description : " + todo.getDescription() + ", Todo Priority := "+todo.getPriority();
    }
}
