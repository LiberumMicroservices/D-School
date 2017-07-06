package com.school.data.entity.school;

import com.school.data.entity.courses.Course;
import com.school.data.entity.students.Student;
import com.school.data.entity.workers.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SchoolTest {

    School school1;
    School school2;

    @Before
    public void init(){
        school1 = new School();
        school2 = new School();
    }

    @Test
    public void testAddStudent() {
        Student student1 = new Student();
        Student student2 = new Student();

        school1.addStudent(student1);
        school2.addStudent(student1);
        school2.addStudent(student2);

        Assert.assertEquals(1, school1.getStudents().size());
        Assert.assertEquals(2, school2.getStudents().size());
    }

    @Test
    public void testAddWorker() {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

        school1.addWorker(worker1);
        school2.addWorker(worker1);
        school2.addWorker(worker2);

        Assert.assertEquals(1, school1.getWorkers().size());
        Assert.assertEquals(2, school2.getWorkers().size());
    }

    @Test
    public void testAddCourse() {
        Course course1 = new Course();
        Course course2 = new Course();

        school1.addCourse(course1);
        school2.addCourse(course1);
        school2.addCourse(course2);

        Assert.assertEquals(1, school1.getCourses().size());
        Assert.assertEquals(2, school2.getCourses().size());
    }
}