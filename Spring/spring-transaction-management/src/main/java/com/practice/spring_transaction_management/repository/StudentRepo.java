package com.practice.spring_transaction_management.repository;

import com.practice.spring_transaction_management.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
