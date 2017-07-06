package com.school.data.entity.students.service.impl;

import com.school.data.entity.students.StudentPayment;
import com.school.data.entity.students.repository.StudentPaymentRepository;
import com.school.data.entity.students.service.StudentPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPaymentServiceImpl implements StudentPaymentService {

    @Autowired
    private StudentPaymentRepository studentPaymentRepository;

    @Override
    public StudentPayment editStudentPayment(StudentPayment studentPayment) {
        return studentPaymentRepository.saveAndFlush(studentPayment);
    }
}
