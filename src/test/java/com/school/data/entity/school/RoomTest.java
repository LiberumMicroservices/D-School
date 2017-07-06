package com.school.data.entity.school;

import com.school.data.entity.courses.Course;
import org.junit.Assert;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testAddCourse() {
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();

        Course course1 = new Course();
        Course course2 = new Course();

        room1.addCourse(course1);
        room2.addCourse(course1);
        course1.addRoom(room3);

        course2.addRoom(room2);

        Assert.assertEquals(1, room1.getCourses().size());
        Assert.assertEquals(2, room2.getCourses().size());
        Assert.assertEquals(1, room3.getCourses().size());
        Assert.assertEquals(3, course1.getRooms().size());
        Assert.assertEquals(1, course2.getRooms().size());
    }
}