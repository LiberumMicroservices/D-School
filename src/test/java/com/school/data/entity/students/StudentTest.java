package com.school.data.entity.students;

import com.school.data.entity.courses.Course;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testAddCourse() {

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        Course course1 = new Course();
        Course course2 = new Course();


        course1.addStudent(student1);
        course1.addStudent(student2);
        student3.addCourse(course1);

        student3.addCourse(course2);

        Assert.assertEquals(1, student1.getCourses().size());
        Assert.assertEquals(1, student2.getCourses().size());
        Assert.assertEquals(2, student3.getCourses().size());
        Assert.assertEquals(3, course1.getStudents().size());
        Assert.assertEquals(1, course2.getStudents().size());
    }

    @Test
    public void testAddResponsiblePerson() {

        Student student1 = new Student();
        Student student2 = new Student();

        ResponsiblePerson responsiblePerson1 = new ResponsiblePerson();
        ResponsiblePerson responsiblePerson2 = new ResponsiblePerson();

        student1.addResponsiblePerson(responsiblePerson1);

        student2.addResponsiblePerson(responsiblePerson1);
        student2.addResponsiblePerson(responsiblePerson2);

        Assert.assertEquals(1, student1.getResponsiblePersons().size());
        Assert.assertEquals(2, student2.getResponsiblePersons().size());

    }
}