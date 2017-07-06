package com.school.data.entity.courses.service.impl;

import com.school.data.entity.courses.PaymentCourse;
import com.school.data.entity.courses.repository.PaymentCourseRepository;
import com.school.data.entity.courses.service.PaymentCourseService;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentCourseServiceImpl implements PaymentCourseService {

    @Autowired
    private PaymentCourseRepository paymentCourseRepository;

    @Override
    public PaymentCourse editPaymentCourse(PaymentCourse paymentCourse) {
        return paymentCourseRepository.saveAndFlush(paymentCourse);
    }
}
