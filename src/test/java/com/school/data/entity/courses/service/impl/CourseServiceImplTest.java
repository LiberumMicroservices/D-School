package com.school.data.entity.courses.service.impl;

import com.school.data.entity.config.TestDataBaseConfig;
import com.school.data.entity.courses.Course;
import com.school.data.entity.courses.service.CourseService;
import com.school.data.entity.util.Util;
import org.junit.After;
import org.junit.Assert;
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
public class CourseServiceImplTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private CourseService courseService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
        courseService.addCourse(Util.createCourse());
    }
    @After
    public void clear(){
        List<Course> courses = courseService.getAllCourses();
        for(Course c: courses)
            courseService.deleteCourse(c.getId());
    }

    @Test
    public void testGetByTitle() {
        Assert.assertEquals("First course", courseService.getByTitle("First course").get(0).getTitle());
    }

    @Test
    public void testEditCourse() {
        Course course = courseService.getByTitle("First course").get(0);
        course.setTitle("test");
        courseService.editCourse(course);
        Assert.assertEquals("test", courseService.getAllCourses().get(0).getTitle());
    }

    @Test
    public void testGetAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        Assert.assertEquals(1, courses.size());
    }

    @Test
    public void testGetBySchool() {
        List<Course> courses = courseService.getBySchool(courseService.getAllCourses().get(0).getSchool());
        Assert.assertEquals(1, courses.size());
    }

    @Test
    public void testDeleteCourse() {
        List<Course> courses = courseService.getAllCourses();
        int exp = courses.size() - 1;
        courseService.deleteCourse(courseService.getAllCourses().get(0));
        int act = courseService.getAllCourses().size();
        Assert.assertEquals(exp, act);
    }
}