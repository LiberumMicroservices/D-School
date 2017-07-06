package com.school.data.entity.courses.service.impl;

import com.school.data.entity.school.School;
import com.school.data.entity.courses.Course;
import com.school.data.entity.courses.repository.CourseRepository;
import com.school.data.entity.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.delete(id);
    }

    @Override
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    @Override
    public List<Course> getByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    @Override
    public Course editCourse(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getBySchool(School school) {
        return courseRepository.findBySchool(school);
    }
}
