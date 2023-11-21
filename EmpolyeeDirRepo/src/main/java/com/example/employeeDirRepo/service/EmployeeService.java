package com.example.employeeDirRepo.service;

import java.util.List;

import com.example.employeeDirRepo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(FindByIdParameter parameterObject);
	
	Employee save(Employee emp);
	
	void delete(int id);

}
