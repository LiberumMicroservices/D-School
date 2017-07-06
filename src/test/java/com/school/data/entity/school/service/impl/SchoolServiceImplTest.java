package com.school.data.entity.school.service.impl;

import com.school.data.entity.config.TestDataBaseConfig;
import com.school.data.entity.school.School;
import com.school.data.entity.school.service.SchoolService;
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
public class SchoolServiceImplTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private SchoolService schoolService;

    @Before
    public void setUp() throws Exception{
        em = emf.createEntityManager();
        schoolService.addSchool(Util.createSchool());
    }

    @After
    public void clear(){
        List<School> schools = schoolService.getAllSchool();
        for(School s: schools)
            schoolService.deleteSchool(s);
    }

    @Test
    public void testAddSchool() {
        schoolService.addSchool(Util.createSchool());
    }

    @Test
    public void testDeleteSchool() {
        schoolService.addSchool(Util.createSchool());
        schoolService.deleteSchool(schoolService.getAllSchool().get(0).getId());
    }

    @Test
    public void testDeleteSchool1() {
        School school = schoolService.addSchool(Util.createSchool());
        schoolService.deleteSchool(school);
    }

    @Test
    public void testEditSchool() {

        List<School> schools = schoolService.getAllSchool();
        School school = schools.get(0);
        school.setName("test");
        schoolService.editSchool(school);

        Assert.assertEquals(schoolService.getAllSchool().size(), schools.size());
        Assert.assertEquals(schoolService.getAllSchool().get(0).getName(), "test");
    }

    @Test
    public void testGetSchoolByName() {
        School school = new School();
        school.setName("test");
        schoolService.addSchool(new School());
        schoolService.addSchool(school);
        List<School> schools = schoolService.getSchoolByName("school");

        for (School s: schools)
            Assert.assertEquals(s.getName(), "school");
    }

    @Test
    public void testGetAllSchool() {
        schoolService.getAllSchool();
    }
}