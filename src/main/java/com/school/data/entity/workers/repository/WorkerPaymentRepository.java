package com.school.data.entity.workers.repository;

import com.school.data.entity.workers.WorkerPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerPaymentRepository extends JpaRepository<WorkerPayment, Long> {
}
