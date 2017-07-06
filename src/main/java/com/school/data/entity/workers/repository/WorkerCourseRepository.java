package com.school.data.entity.workers.repository;

import com.school.data.entity.courses.Course;
import com.school.data.entity.workers.WorkerCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerCourseRepository extends JpaRepository<WorkerCourse, Long> {

    @Query("select w from WorkerCourse w where w.course = :course")
    List<WorkerCourse> findByCourse(@Param("course") Course course);
}
