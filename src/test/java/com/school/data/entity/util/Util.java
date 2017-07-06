package com.school.data.entity.util;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.Room;
import com.school.data.entity.school.School;
import com.school.data.entity.students.ResponsiblePerson;
import com.school.data.entity.students.Student;
import com.school.data.entity.students.StudentCourse;
import com.school.data.entity.students.StudentPayment;
import com.school.data.entity.workers.Worker;
import com.school.data.entity.workers.enums.WorkerStatus;

import java.util.HashSet;
import java.util.Set;

public class Util {

    public static Course createCourse(){
        School school = new School();
        school.setName("Salsa");
        Course c = new Course();
        c.setSchool(school);
        c.setTitle("First course");
        return c;
    }

    public static Room createRoom(){
        School school = new School();
        school.setName("school");

        Course course = new Course();
        course.setTitle("course");
        Set<Course> courses = new HashSet<>();
        courses.add(course);

        Room room = new Room();
        room.setTitle("room");

        course.setSchool(school);
        room.setSchool(school);
        room.setCourses(courses);

        return room;
    }

    public static School createSchool(){
        School school = new School();
        school.setName("school");

        return school;
    }

    public static ResponsiblePerson createResponciblePerson(){
        School school = new School();
        school.setName("school");

        ResponsiblePerson responsiblePerson = new ResponsiblePerson();
        responsiblePerson.setfName("responsible person");

        Student student = new Student();
        student.setfName("f name");
        student.setSchool(school);
        student.addResponsiblePerson(responsiblePerson);

        return responsiblePerson;
    }

    public static StudentCourse createStudentCourse(){
        StudentCourse studentCourse = new StudentCourse();
        StudentPayment studentPayment = new StudentPayment();

        studentCourse.setStudentPayment(studentPayment);
        studentCourse.setCourse(createCourse());
        return studentCourse;
    }

    public static Worker createWorker(){
        Worker worker = new Worker();
        worker.setSchool(createSchool());
        worker.setfName("Al");
        worker.setlName("Sh");
        worker.setEmail("admin");
        worker.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
        worker.setStatus(WorkerStatus.ADMIN);

        return worker;
    }
}
