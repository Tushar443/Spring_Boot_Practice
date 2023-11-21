package com.example.employeeDir.dao.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employeeDir.dao.EmployeeDAO;
import com.example.employeeDir.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class EmployeeDaoImple implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityM ;

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityM.createQuery("from Employee",Employee.class);
		return theQuery.getResultList();
	}

	@Override
	public Employee findById(int id) {
		return entityM.find(Employee.class, id);
	}

	@Override
	public Employee save(Employee emp) {
		return entityM.merge(emp);
	}

	@Override
	public Employee delete(int id) {
		Employee dbEmp = findById(id);
		
		entityM.remove(dbEmp);
		return dbEmp;
	}

}
