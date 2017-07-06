package com.school.data.entity.students;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment_student")
public class StudentPayment {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Student student;

    // максимальная задолженость
    @Column(name = "credit")
    private int credit;

    // список курсов студента и скидки на каждый
    @OneToMany(mappedBy = "studentPayment")
    Set<StudentCourse> studentCourses;

    public void addStudentCourse(StudentCourse studentCourse){
        if(this.studentCourses == null)
            this.studentCourses = new HashSet<>();

        studentCourse.setStudentPayment(this);
        this.studentCourses.add(studentCourse);
    }

    public StudentPayment() {
    }

    public StudentPayment(Student student, int credit, Set<StudentCourse> studentCourses) {
        this.student = student;
        this.credit = credit;
        this.studentCourses = studentCourses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
