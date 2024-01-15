package com.springBoot.RestApiConsumePractice.Controller.Client;

import com.springBoot.RestApiConsumePractice.ResponseEntity.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name = "USER-CLIENT")
public interface UserClient {

    @GetMapping("/users")
    public List<UserResponse> getUsers();
}
