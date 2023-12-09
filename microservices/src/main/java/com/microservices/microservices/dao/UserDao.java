package com.microservices.microservices.dao;

import com.microservices.microservices.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserDao extends JpaRepository<User,String> {
    Optional<User> findUserByEmail(String email);

//    //Query
//    @Query(name = "SELECT * FROM user WHERE email=:emailId",nativeQuery = true)
//    Optional<User> findUserByTheEmail(@Param("emailId") String email);
//
//    //native method
//    User findOne(String email);
}
