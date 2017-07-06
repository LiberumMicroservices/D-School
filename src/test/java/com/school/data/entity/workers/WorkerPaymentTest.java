package com.school.data.entity.workers;

import org.junit.*;

public class WorkerPaymentTest {

    @Test
    public void testAddWorkerCourse() {

        WorkerPayment workerPayment1 = new WorkerPayment();
        WorkerPayment workerPayment2 = new WorkerPayment();

        WorkerCourse workerCourse1 = new WorkerCourse();
        WorkerCourse workerCourse2 = new WorkerCourse();

        workerPayment1.addWorkerCourse(workerCourse1);
        workerPayment2.addWorkerCourse(workerCourse1);
        workerPayment2.addWorkerCourse(workerCourse2);

        Assert.assertEquals(1, workerPayment1.getWorkerCourses().size());
        Assert.assertEquals(2, workerPayment2.getWorkerCourses().size());
    }
}