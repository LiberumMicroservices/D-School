package com.school.data.entity.courses.repository;

import com.school.data.entity.courses.PaymentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCourseRepository extends JpaRepository<PaymentCourse, Long> {
}
