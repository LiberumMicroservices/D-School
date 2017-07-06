package com.school.data.entity.students;

import com.school.data.entity.courses.Course;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// детализация по курсу для студента
@Entity
@Table(name = "student_course")
public class StudentCourse {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "status")
    private boolean status;

    @Column(name = "discount")
    private int discount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "student_payment_id", nullable = false)
    private StudentPayment studentPayment;

    public StudentCourse() {
    }

    public StudentCourse(int discount, boolean status, Course course, StudentPayment studentPayment) {
        this.status = status;
        this.discount = discount;
        this.course = course;
        this.studentPayment = studentPayment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudentPayment getStudentPayment() {
        return studentPayment;
    }

    public void setStudentPayment(StudentPayment studentPayment) {
        this.studentPayment = studentPayment;
    }
}
