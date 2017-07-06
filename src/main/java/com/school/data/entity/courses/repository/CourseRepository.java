package com.school.data.entity.courses.repository;

import com.school.data.entity.school.School;
import com.school.data.entity.courses.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c where c.title = :title")
    List<Course> findByTitle(@Param("title") String title);

    @Query("select c from Course c where c.school = :school")
    List<Course> findBySchool(@Param("school") School school);
}
