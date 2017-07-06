package com.school.data.entity.workers;

import com.school.data.entity.courses.Course;
import org.junit.Assert;
import org.junit.Test;

public class WorkerTest {

    @Test
    public void testAddCourse() {

        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        Worker worker3 = new Worker();

        Course course1 = new Course();
        Course course2 = new Course();

        course1.addWorker(worker1);
        course1.addWorker(worker2);
        worker3.addCourse(course1);

        worker3.addCourse(course2);

        Assert.assertEquals(1, worker1.getCourses().size());
        Assert.assertEquals(1, worker2.getCourses().size());
        Assert.assertEquals(2, worker3.getCourses().size());
        Assert.assertEquals(3, course1.getWorkers().size());
        Assert.assertEquals(1, course2.getWorkers().size());
    }
}