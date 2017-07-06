package com.school.data.entity.workers;

import com.school.data.entity.courses.Course;
import com.school.data.entity.workers.enums.WorkerPaymentType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "worker_course")
public class WorkerCourse {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "worker_payment_type")
    @Enumerated(EnumType.STRING)
    private WorkerPaymentType workerPaymentType;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "worker_course_id", nullable = false)
    private WorkerPayment workerPayment;

    public WorkerCourse() {
    }

    public WorkerCourse(Course course, WorkerPaymentType workerPaymentType, int price, WorkerPayment workerPayment) {
        this.course = course;
        this.workerPaymentType = workerPaymentType;
        this.price = price;
        this.workerPayment = workerPayment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public WorkerPaymentType getWorkerPaymentType() {
        return workerPaymentType;
    }

    public void setWorkerPaymentType(WorkerPaymentType workerPaymentType) {
        this.workerPaymentType = workerPaymentType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public WorkerPayment getWorkerPayment() {
        return workerPayment;
    }

    public void setWorkerPayment(WorkerPayment workerPayment) {
        this.workerPayment = workerPayment;
    }
}
