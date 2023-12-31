package com.example.employeeDir.dao;

import java.util.List;

import com.example.employeeDir.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee emp);
	
	Employee delete(int id);
}
