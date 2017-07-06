package com.school.data.entity.school.service.impl;

import com.school.data.entity.config.TestDataBaseConfig;
import com.school.data.entity.courses.Course;
import com.school.data.entity.school.Room;
import com.school.data.entity.school.School;
import com.school.data.entity.school.service.RoomService;
import com.school.data.entity.util.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration("com.school.data")
public class RoomServiceImplTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private RoomService roomService;

    @Before
    public void setUp() throws Exception{
        em = emf.createEntityManager();
        roomService.addRoom(Util.createRoom());
    }

    @After
    public void clear(){
        List<Room> rooms = roomService.getAllRooms();
        for(Room r :rooms)
            roomService.deleteRoom(r);
    }

    @Test
    public void testAddRoom() {
        roomService.addRoom(Util.createRoom());
    }

    @Test
    public void testDeleteRoom() {
        roomService.deleteRoom(roomService.getAllRooms().get(0));
    }

    @Test
    public void testDeleteRoom1() {
        roomService.deleteRoom(roomService.getAllRooms().get(0).getId());
    }

    @Test
    public void testEditRoom() {
        List<Room> rooms = roomService.getAllRooms();
        Room room = rooms.get(0);
        room.setTitle("test");
        roomService.editRoom(room);
        Assert.assertEquals(roomService.getAllRooms().size(), rooms.size());
        Assert.assertEquals(roomService.getAllRooms().get(0).getTitle(), "test");
    }

    @Test
    public void testGetRoomById() {
        roomService.getRoomById(0);
    }

    @Test
    public void testGetAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
    }

    @Test
    public void testGetRoomsByCourse() {
            List<Course> courses = new ArrayList<>(roomService.getAllRooms().get(0).getCourses());
            Course course = courses.get(0);
            roomService.getRoomsByCourse(course);
    }

    @Test
    public void testGetRoomsBySchool() {
        School school = roomService.getAllRooms().get(0).getSchool();
        roomService.getRoomsBySchool(school);
    }
}