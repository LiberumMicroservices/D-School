package com.school.data.entity.courses.service;

import com.school.data.entity.school.School;
import com.school.data.entity.courses.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    void deleteCourse(long id);
    void deleteCourse(Course course);
    Course editCourse(Course course);
    List<Course> getByTitle(String title);
    List<Course> getAllCourses();
    List<Course> getBySchool(School school);
}
