package com.example.restApi.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.entity.Student;
import com.example.restApi.entity.StudentErrorResponse;
import com.example.restApi.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudent;
	
	@PostConstruct
	public void loadData() {
		theStudent = new ArrayList<Student>();	
		theStudent.add(new Student("Tushar","More"));
		theStudent.add(new Student("Thunder","moore"));
		theStudent.add(new Student("Prkash","Moreee"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudent;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getOneStudent(@PathVariable int studentId){
		
		if((studentId>= theStudent.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not Found - "+studentId);
		}
		
		return theStudent.get(studentId);
	}
	
}
