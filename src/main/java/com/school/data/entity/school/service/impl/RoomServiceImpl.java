package com.school.data.entity.school.service.impl;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.Room;
import com.school.data.entity.school.School;
import com.school.data.entity.school.repository.RoomRepository;
import com.school.data.entity.school.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.saveAndFlush(room);
    }

    @Override
    public void deleteRoom(long id) {
        roomRepository.delete(id);
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public Room editRoom(Room room) {
        return roomRepository.saveAndFlush(room);
    }

    @Override
    public Room getRoomById(long id) {
        return roomRepository.findOne(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getRoomsByCourse(Course course) {
        return roomRepository.findByCourses(course);
    }

    @Override
    public List<Room> getRoomsBySchool(School school) {
        return roomRepository.findBySchool(school);
    }
}
