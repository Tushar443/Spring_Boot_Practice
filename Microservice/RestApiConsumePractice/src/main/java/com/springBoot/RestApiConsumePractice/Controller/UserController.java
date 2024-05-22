package com.springBoot.RestApiConsumePractice.Controller;

import com.springBoot.RestApiConsumePractice.Controller.Client.UserClient;
import com.springBoot.RestApiConsumePractice.ResponseEntity.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserClient userClient;
    @GetMapping(value = "/fetch1")
    public List<UserResponse> getFetchUSers1(){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users",List.class);
    }
    @GetMapping(value = "/fetch2")
    public List<UserResponse> getFetchUser2(){
        return userClient.getUsers();
    }
}
