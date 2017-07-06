package com.school.data.entity.school.service;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.Room;
import com.school.data.entity.school.School;

import java.util.List;

public interface RoomService {
    Room addRoom(Room room);
    void deleteRoom(long id);
    void deleteRoom(Room room);
    Room editRoom(Room room);
    Room getRoomById(long id);
    List<Room> getAllRooms();
    List<Room> getRoomsByCourse(Course course);
    List<Room> getRoomsBySchool(School school);
}
