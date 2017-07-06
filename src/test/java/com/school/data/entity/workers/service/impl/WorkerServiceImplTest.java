package com.school.data.entity.workers.service.impl;

import com.school.data.entity.config.TestDataBaseConfig;
import com.school.data.entity.util.Util;
import com.school.data.entity.workers.Worker;
import com.school.data.entity.workers.service.WorkerService;
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

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration("com.school.data")
public class WorkerServiceImplTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private WorkerService workerService;

    @Before
    public void setUp() throws Exception{
        em = emf.createEntityManager();
        try {
            workerService.addWorker(Util.createWorker());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddWorker() {
        //TODO create test
    }

    @Test
    public void testEditWorker() {
        //TODO create test
    }

    @Test
    public void testDeleteWorker() {
        //TODO create test
    }

    @Test
    public void testDeleteWorker1() {
        //TODO create test
    }

    @Test
    public void testGetAllWorkers() {
        //TODO create test
    }

    @Test
    public void testGetWorkersBySchool() {
        //TODO create test
    }

    @Test
    public void testGetWorkersByCourse() {
        //TODO create test
    }

    @Test
    public void testGetWorkerByEmail() {
        Worker worker = workerService.getWorkerByEmail("admin");
        Assert.assertEquals(worker.getEmail(), "admin");
    }
}