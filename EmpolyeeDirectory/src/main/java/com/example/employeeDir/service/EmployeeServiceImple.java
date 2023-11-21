package com.example.employeeDir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeDir.dao.EmployeeDAO;
import com.example.employeeDir.entity.Employee;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee emp) {
		return employeeDAO.save(emp);
	}

	@Override
	@Transactional
	public Employee delete(int id) {
		return employeeDAO.delete(id);
	}

}
