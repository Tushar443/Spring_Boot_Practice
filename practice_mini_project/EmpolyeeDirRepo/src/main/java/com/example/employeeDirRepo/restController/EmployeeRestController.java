package com.example.employeeDirRepo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeDirRepo.entity.Employee;
import com.example.employeeDirRepo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//	@Autowired
//	private EmployeeService employeeService;
//	
//	@GetMapping("/emp")
//	public List<Employee> getEmployees(){
//		return employeeService.findAll();
//	}
//	
//	@GetMapping("/emp/{empId}")
//	public Employee getEmployee(@PathVariable int empId){
//		Employee db = employeeService.findById(empId);
//		if(db == null) {
//			throw new RuntimeException("Employee Id not found - "+empId);
//		}
//		return db;
//	}
//	
//	@PostMapping("/emp")
//	public Employee saveEmployee(@RequestBody Employee emp){
//		Employee dbEmployee = employeeService.save(emp);
//		return dbEmployee;
//	}
//	
//	@PutMapping("/emp")
//	public Employee updateEmployee(@RequestBody Employee emp){
//		
//		Employee dbEmp = employeeService.save(emp);
//		
//		return dbEmp;
//	}
//	
//	@DeleteMapping("/emp/{empId}")
//	public void deleteEmployee(@PathVariable int empId){
//		 employeeService.delete(empId);
//		 System.out.println("Employyee deleted = "+empId);
//	}
//	
}
