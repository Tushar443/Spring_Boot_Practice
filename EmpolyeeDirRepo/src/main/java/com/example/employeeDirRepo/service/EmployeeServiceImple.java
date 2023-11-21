package com.example.employeeDirRepo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeDirRepo.dao.EmployeeDAO;
import com.example.employeeDirRepo.entity.Employee;
import com.example.employeeDirRepo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById( int id ) {
		return employeeRepo.findById(parameterObject.id);
	}

	@Override
	public Employee save(Employee emp) {
		return employeeRepo.save(emp);
	}

	@Override
	public void delete(int id) {
		 employeeRepo.deleteById(id);
	}

}
