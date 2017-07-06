package com.school.data.entity.students;

import org.junit.Assert;
import org.junit.Test;

public class StudentPaymentTest {

    @Test
    public void testAddStudentCourse() {

        StudentPayment studentPayment1 = new StudentPayment();
        StudentPayment studentPayment2 = new StudentPayment();

        StudentCourse studentCourse1 = new StudentCourse();
        StudentCourse studentCourse2 = new StudentCourse();

        studentPayment1.addStudentCourse(studentCourse1);

        studentPayment2.addStudentCourse(studentCourse1);
        studentPayment2.addStudentCourse(studentCourse2);

        Assert.assertEquals(1, studentPayment1.getStudentCourses().size());
        Assert.assertEquals(2, studentPayment2.getStudentCourses().size());
    }
}