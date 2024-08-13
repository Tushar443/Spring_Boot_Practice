package com.practice.spring_transaction_management.controller;

import com.practice.spring_transaction_management.service.IStudentService;
import com.practice.spring_transaction_management.service.StudentService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentService service;

    IStudentService intefaceStudent;

    public StudentController(StudentService service, IStudentService intefaceStudent) {
        this.service = service;
        this.intefaceStudent = intefaceStudent;
    }

    @GetMapping("/hello")
    @Transactional(propagation = Propagation.REQUIRED)
    public String getHello() throws Exception {
        service.addStudent();
        return "HELLO";
    }

    @GetMapping("/hello/{id}")
    public String updateStudent(@PathVariable long id){
        intefaceStudent.updateStudent(id);
        return "Updated";
    }
}
