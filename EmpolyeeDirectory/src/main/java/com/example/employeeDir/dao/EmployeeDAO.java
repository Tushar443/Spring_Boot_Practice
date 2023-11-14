package com.example.employeeDir.dao;

import java.util.List;

import com.example.employeeDir.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
}
