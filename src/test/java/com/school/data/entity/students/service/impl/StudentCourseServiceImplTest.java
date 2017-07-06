package com.school.data.entity.students.service.impl;

import com.school.data.entity.config.TestDataBaseConfig;
import com.school.data.entity.students.StudentCourse;
import com.school.data.entity.students.service.StudentCourseService;
import com.school.data.entity.util.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration("com.school.data")
public class StudentCourseServiceImplTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    StudentCourseService studentCourseService;

    @Before
    public void setUp() throws Exception{
        em = emf.createEntityManager();
        studentCourseService.addStudentCourse(Util.createStudentCourse());
    }

    @After
    public void clear(){
        List<StudentCourse> studentCourseList = studentCourseService.getAllStudentCourse();
        for(StudentCourse s :studentCourseList)
            studentCourseService.deleteStudentCourse(s);
    }


    @Test
    public void testAddStudentCourse() {
        studentCourseService.addStudentCourse(Util.createStudentCourse());
    }

    @Test
    public void testDeleteStudentCourse() {

    }

    @Test
    public void testDeleteStudentCourse1() {

    }

    @Test
    public void testEditStudentCourse() {

    }

    @Test
    public void testGetAllStudentCourse() {

    }

    @Test
    public void testGetStudentCourseByCourse() {

    }
}