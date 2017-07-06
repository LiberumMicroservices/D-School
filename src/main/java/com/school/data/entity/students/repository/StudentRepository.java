package com.school.data.entity.students.repository;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.school = :school")
    List<Student> findBySchool(@Param("school") School school);

    @Query("select s from Student s where s.courses = :course")
    List<Student> findByCoursesCourse(@Param("course") Course course);
}
