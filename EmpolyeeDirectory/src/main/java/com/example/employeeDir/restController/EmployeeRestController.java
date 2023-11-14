package com.example.employeeDir.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeDir.dao.EmployeeDAO;
import com.example.employeeDir.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/emp")
	public List<Employee> getEmployee(){
		return employeeDAO.findAll();
	}
}
