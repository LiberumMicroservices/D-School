package com.school.data.entity.students.service.impl;

import com.school.data.entity.config.TestDataBaseConfig;
import com.school.data.entity.students.ResponsiblePerson;
import com.school.data.entity.students.Student;
import com.school.data.entity.students.service.ResponsiblePersonService;
import com.school.data.entity.students.service.StudentService;
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
public class ResponsiblePersonServiceImplTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private ResponsiblePersonService responsiblePersonService;

    @Resource
    private StudentService studentService;

    @Before
    public void setUp() throws Exception{
        em = emf.createEntityManager();
        responsiblePersonService.addResponsiblePerson(Util.createResponciblePerson());
    }

    @After
    public void clear(){
        List<ResponsiblePerson> responsiblePersons = responsiblePersonService.getAllResponsiblePerson();
        for(ResponsiblePerson r :responsiblePersons)
            responsiblePersonService.deleteResponsiblePerson(r);
    }

    @Test
    public void testAddResponsiblePerson() {
        List<ResponsiblePerson> responsiblePersons = responsiblePersonService.getAllResponsiblePerson();
        responsiblePersonService.addResponsiblePerson(Util.createResponciblePerson());

        Assert.assertEquals(responsiblePersons.size() + 1, responsiblePersonService.getAllResponsiblePerson().size());
    }

    @Test
    public void testDeleteResponsiblePerson() {
        List<ResponsiblePerson> responsiblePersons = responsiblePersonService.getAllResponsiblePerson();
        ResponsiblePerson responsiblePerson = responsiblePersons.get(0);
        responsiblePersonService.deleteResponsiblePerson(responsiblePerson);
    }

    @Test
    public void testDeleteResponsiblePerson1() {
        List<ResponsiblePerson> responsiblePersons = responsiblePersonService.getAllResponsiblePerson();
        ResponsiblePerson responsiblePerson = responsiblePersons.get(0);
        responsiblePersonService.deleteResponsiblePerson(responsiblePerson.getId());
    }

    @Test
    public void testEditResponsiblePerson() {
        List<ResponsiblePerson> responsiblePersons = responsiblePersonService.getAllResponsiblePerson();
        ResponsiblePerson responsiblePerson = responsiblePersons.get(0);
        responsiblePerson.setlName("l name");
        responsiblePersonService.editResponsiblePerson(responsiblePerson);
        Assert.assertEquals(responsiblePersonService.getAllResponsiblePerson().size(), responsiblePersons.size());
        Assert.assertEquals(responsiblePersonService.getAllResponsiblePerson().get(0).getlName(), "l name");
    }

    @Test
    public void testGetAllResponsiblePerson() {
        responsiblePersonService.getAllResponsiblePerson();
    }

    @Test
    public void testGetResponsiblePersonByStudent() {
        Student student =  responsiblePersonService.getAllResponsiblePerson().get(0).getStudent();
        ResponsiblePerson responsiblePerson = responsiblePersonService.getResponsiblePersonByStudent(student).get(0);
        Assert.assertEquals(student.getId(), responsiblePerson.getStudent().getId());
    }
}