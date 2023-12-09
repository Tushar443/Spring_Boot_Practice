package com.microservices.microservices.dao;

import com.microservices.microservices.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoDao extends JpaRepository<ToDo,Integer> {

    List<ToDo> findByFkUser(String email);
}
