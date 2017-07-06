package com.school.data.entity.students.service.impl;

import com.school.data.entity.courses.Course;
import com.school.data.entity.students.StudentCourse;
import com.school.data.entity.students.repository.StudentCourseRepositopy;
import com.school.data.entity.students.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentCourseRepositopy studentCourseRepositopy;

    @Override
    public StudentCourse addStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepositopy.saveAndFlush(studentCourse);
    }

    @Override
    public void deleteStudentCourse(long id) {
        studentCourseRepositopy.delete(id);
    }

    @Override
    public void deleteStudentCourse(StudentCourse studentCourse) {
        studentCourseRepositopy.delete(studentCourse);
    }

    @Override
    public StudentCourse editStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepositopy.saveAndFlush(studentCourse);
    }

    @Override
    public List<StudentCourse> getAllStudentCourse() {
        return studentCourseRepositopy.findAll();
    }

    @Override
    public List<StudentCourse> getStudentCourseByCourse(Course course) {
        return studentCourseRepositopy.findByCourse(course);
    }
}
