package com.example.demo.DAO;

import java.util.List;

import com.example.demo.Entity.Student;

public interface StudentDAO {

	void save(Student student);
	
	Student findById(Integer id);

	List<Student> findAll();
	
	List<Student> findAllByLastName(String lastName);
	
	void updateStudent(Student student);
	
	void deleteStudent(int id);

	int deleteAll();
}
