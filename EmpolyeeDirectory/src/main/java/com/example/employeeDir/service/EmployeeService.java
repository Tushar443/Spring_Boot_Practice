package com.example.employeeDir.service;

import java.util.List;

import com.example.employeeDir.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee emp);
	
	Employee delete(int id);

}
