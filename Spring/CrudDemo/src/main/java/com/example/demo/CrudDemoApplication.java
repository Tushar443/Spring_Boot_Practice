package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.Entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner command(StudentDAO student) {
		return runner->{
			
			createStudent(student);
			
			//readStudent(student);
			
			//queryForAllStuedent(student);
			
			//findAllByLastName(student);
			
			//updateStudent(student);
			
			//deleteStudent(student);
			
			//deleteAll(student);
		};
	}

	private void deleteAll(StudentDAO student) {
		int deleteRows = student.deleteAll();
		System.out.println("deleted All"+deleteRows);
	}

	private void deleteStudent(StudentDAO student) {
		student.deleteStudent(2);
		System.out.println("deleted");
	}

	private void updateStudent(StudentDAO student) {
		Student tempStudent = student.findById(2);
		
		tempStudent.setFirstName("changed");
		
		student.updateStudent(tempStudent);
		System.out.println("Student Updated");
	}

	private void findAllByLastName(StudentDAO student) {
		List<Student> theStudents=student.findAllByLastName("moore");
		for(Student s : theStudents) {
			System.out.println(s);
		}
	}

	private void queryForAllStuedent(StudentDAO student) {
		List<Student> theStudents=student.findAll();
		for(Student s : theStudents) {
			System.out.println(s);
		}
		
	}

	private void readStudent(StudentDAO i) {
		Student student= i.findById(2); 
		System.out.println(student);
	}

	@SuppressWarnings("unused")
	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Rahul","More","Rahul@gmail.com");
		Student tempStudent1 = new Student("Thunder","More","Thunder@gmail.com");
		Student tempStudent2 = new Student("Prakash","More","Prakash@gmail.com");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		
		System.out.println("Saved :="+tempStudent.getID());
		
	}
	
	
	
}
