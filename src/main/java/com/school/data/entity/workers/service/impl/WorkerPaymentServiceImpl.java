package com.school.data.entity.workers.service.impl;

import com.school.data.entity.workers.WorkerPayment;
import com.school.data.entity.workers.repository.WorkerPaymentRepository;
import com.school.data.entity.workers.service.WorkerPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerPaymentServiceImpl implements WorkerPaymentService {

    @Autowired
    private WorkerPaymentRepository workerPaymentRepository;

    @Override
    public WorkerPayment editWorkerPayment(WorkerPayment workerPayment) {
        return workerPaymentRepository.saveAndFlush(workerPayment);
    }
}
