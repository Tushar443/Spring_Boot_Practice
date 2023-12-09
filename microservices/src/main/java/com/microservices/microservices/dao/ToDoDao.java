package com.microservices.microservices.dao;

import com.microservices.microservices.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToDoDao extends JpaRepository<ToDo,Integer> {

    List<ToDo> findByFkUser(String email);
}
