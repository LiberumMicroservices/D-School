package com.school.data.entity.students.repository;

import com.school.data.entity.students.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPaymentRepository extends JpaRepository<StudentPayment, Long> {
}
