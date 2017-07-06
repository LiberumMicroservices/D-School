package com.school.data.entity.workers;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment_worker")
public class WorkerPayment {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    // выданый аванс
    @Column(name = "credit")
    private int credit;

    // минимально гарантированная ставка
    @Column(name = "fixed_min")
    private int fixedMin;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Worker worker;

    // список курсов с типом оплаты
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workerPayment")
    private Set<WorkerCourse> workerCourses;

    public void addWorkerCourse(WorkerCourse workerCourse){
        if(this.workerCourses == null)
            this.workerCourses = new HashSet<>();

        workerCourse.setWorkerPayment(this);
        this.workerCourses.add(workerCourse);
    }

    public WorkerPayment() {
    }

    public WorkerPayment(int credit, int fixedMin, Worker worker, Set<WorkerCourse> workerCourses) {
        this.credit = credit;
        this.fixedMin = fixedMin;
        this.workerCourses = workerCourses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getFixedMin() {
        return fixedMin;
    }

    public void setFixedMin(int fixedMin) {
        this.fixedMin = fixedMin;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Set<WorkerCourse> getWorkerCourses() {
        return workerCourses;
    }

    public void setWorkerCourses(Set<WorkerCourse> workerCourses) {
        this.workerCourses = workerCourses;
    }
}
