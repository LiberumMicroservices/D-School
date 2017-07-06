package com.school.data.entity.workers.repository;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.workers.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("select w from Worker w where w.school = :school")
    List<Worker> findBySchool(@Param("school") School school);

    @Query("select w from Worker w where w.courses = :course")
    List<Worker> findByCoursesCourse(@Param("course") Course course);

    Worker findByEmail(String email);
}
