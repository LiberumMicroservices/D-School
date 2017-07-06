package com.school.data.entity.students.service;

import com.school.data.entity.courses.Course;
import com.school.data.entity.students.StudentCourse;

import java.util.List;

public interface StudentCourseService {
    StudentCourse addStudentCourse(StudentCourse studentCourse);
    void deleteStudentCourse(long id);
    void deleteStudentCourse(StudentCourse studentCourse);
    StudentCourse editStudentCourse(StudentCourse studentCourse);
    List<StudentCourse> getAllStudentCourse();
    List<StudentCourse> getStudentCourseByCourse(Course course);
}
