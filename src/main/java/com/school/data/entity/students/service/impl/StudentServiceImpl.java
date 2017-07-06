package com.school.data.entity.students.service.impl;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.students.Student;
import com.school.data.entity.students.repository.StudentRepository;
import com.school.data.entity.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.delete(id);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public List<Student> getStudentsBySchool(School school) {
        return studentRepository.findBySchool(school);
    }

    @Override
    public List<Student> getStudentsByCourse(Course course) {
        return studentRepository.findByCoursesCourse(course);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
