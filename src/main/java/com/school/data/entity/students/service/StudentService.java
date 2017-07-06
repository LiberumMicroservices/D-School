package com.school.data.entity.students.service;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.students.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    void deleteStudent(long id);
    void deleteStudent(Student student);
    Student editStudent(Student student);
    List<Student> getStudentsBySchool(School school);
    List<Student> getStudentsByCourse(Course course);
    List<Student> getAllStudents();

}
