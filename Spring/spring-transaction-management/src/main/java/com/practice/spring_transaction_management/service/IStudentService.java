package com.practice.spring_transaction_management.service;

import org.springframework.transaction.annotation.Transactional;

public interface IStudentService {
    @Transactional
    void updateStudent(long id);
}
