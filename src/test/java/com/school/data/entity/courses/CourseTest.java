package com.school.data.entity.courses;

import com.school.data.entity.school.Room;
import com.school.data.entity.students.Student;
import com.school.data.entity.workers.Worker;
import org.junit.*;

public class CourseTest {

    @Test
    public void testAddRoom() {
        Course course1 = new Course();
        Course course2 = new Course();
        Course course3 = new Course();

        Room room1 = new Room();
        Room room2 = new Room();

        room1.addCourse(course1);
        room1.addCourse(course2);
        course3.addRoom(room1);

        course3.addRoom(room2);

        Assert.assertEquals(1, course1.getRooms().size());
        Assert.assertEquals(1, course2.getRooms().size());
        Assert.assertEquals(2, course3.getRooms().size());
        Assert.assertEquals(3, room1.getCourses().size());
        Assert.assertEquals(1, room2.getCourses().size());
    }

    @Test
    public void testAddStudent() {
        Course course1 = new Course();
        Course course2 = new Course();
        Course course3 = new Course();

        Student student1 = new Student();
        Student student2 = new Student();

        student1.addCourse(course1);
        student1.addCourse(course2);
        course3.addStudent(student1);

        course3.addStudent(student2);

        Assert.assertEquals(1, course1.getStudents().size());
        Assert.assertEquals(1, course2.getStudents().size());
        Assert.assertEquals(2, course3.getStudents().size());
        Assert.assertEquals(3, student1.getCourses().size());
        Assert.assertEquals(1, student2.getCourses().size());
    }

    @Test
    public void testAddWorker() {
        Course course1 = new Course();
        Course course2 = new Course();
        Course course3 = new Course();

        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

        worker1.addCourse(course1);
        worker1.addCourse(course2);
        course3.addWorker(worker1);

        course3.addWorker(worker2);

        Assert.assertEquals(1, course1.getWorkers().size());
        Assert.assertEquals(1, course2.getWorkers().size());
        Assert.assertEquals(2, course3.getWorkers().size());
        Assert.assertEquals(3, worker1.getCourses().size());
        Assert.assertEquals(1, worker2.getCourses().size());
    }

    @Test
    public void testAddPaymentCourse() {

        Course course1 = new Course();
        Course course2 = new Course();

        PaymentCourse paymentCourse1 = new PaymentCourse();
        PaymentCourse paymentCourse2 = new PaymentCourse();

        course1.addPaymentCourse(paymentCourse1);

        course2.addPaymentCourse(paymentCourse1);
        course2.addPaymentCourse(paymentCourse2);

        Assert.assertEquals(1, course1.getPaymentCourses().size());
        Assert.assertEquals(2, course2.getPaymentCourses().size());
    }
}