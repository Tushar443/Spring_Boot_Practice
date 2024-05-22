package com.example.employeeDirRepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.employeeDirRepo.entity.Employee;
@RepositoryRestResource(path = "emp")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
