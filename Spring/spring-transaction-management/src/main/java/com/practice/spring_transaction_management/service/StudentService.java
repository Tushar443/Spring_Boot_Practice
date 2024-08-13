package com.practice.spring_transaction_management.service;

import com.practice.spring_transaction_management.beans.Student;
import com.practice.spring_transaction_management.repository.StudentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService implements IStudentService{

    StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(rollbackFor = {Exception.class})
    public void addStudent() throws Exception {
        //try{
            for(int i = 1 ; i<=10 ;i++){
//                if(i == 7 ){
//                    //throw new Exception("Not a valid arg"); //It will not work for checked Exception.It will add 6 Student into db
//                    throw new RuntimeException("Not a valid arg"); //It will work for Runtime Exception
//                }
                Student s = new Student("Tushar"+i , 10+i*2);
                Student save = studentRepo.save(s);
                System.out.println(save);
            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateStudent(long id) {
        Student student = studentRepo.getById(id);
        System.out.println("Student Updated");
    }
}
