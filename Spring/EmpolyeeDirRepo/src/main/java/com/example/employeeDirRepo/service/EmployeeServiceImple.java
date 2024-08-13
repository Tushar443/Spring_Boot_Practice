package com.example.employeeDirRepo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeDirRepo.entity.Employee;
import com.example.employeeDirRepo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImple implements EmployeeService {

//	@Autowired
//	EmployeeRepository employeeRepo;
//	
//	Employee emp=null;
//	
//	@Override
//	public List<Employee> findAll() {
//		return employeeRepo.findAll();
//	}
//
//	@Override
//	public Employee findById( int id ) {
//		Optional<Employee> result  = employeeRepo.findById(id);
//		if(result.isPresent()) {
//			emp=result.get();
//		}else {
//			throw new RuntimeException("Do Not Find Employee Id := "+id);
//		}
//		return emp;
//	}
//
//	@Override
//	public Employee save(Employee emp) {
//		return employeeRepo.save(emp);
//	}
//
//	@Override
//	public void delete(int id) {
//		 employeeRepo.deleteById(id);
//	}

}
