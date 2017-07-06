package com.school.data.entity.students.repository;

import com.school.data.entity.courses.Course;
import com.school.data.entity.students.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCourseRepositopy extends JpaRepository<StudentCourse, Long> {

    @Query("select s from StudentCourse s where s.course = :course")
    List<StudentCourse> findByCourse(@Param("course") Course course);

}
