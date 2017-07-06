package com.school.data.entity.school.repository;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.Room;
import com.school.data.entity.school.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByCourses(@Param("course") Course course);

    List<Room> findBySchool(@Param("school")School school);
}
