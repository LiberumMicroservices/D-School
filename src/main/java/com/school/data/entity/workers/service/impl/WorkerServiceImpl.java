package com.school.data.entity.workers.service.impl;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.workers.Worker;
import com.school.data.entity.workers.repository.WorkerRepository;
import com.school.data.entity.workers.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.saveAndFlush(worker);
    }

    @Override
    public Worker editWorker(Worker worker) {
        return workerRepository.saveAndFlush(worker);
    }

    @Override
    public void deleteWorker(long id) {
        workerRepository.delete(id);
    }

    @Override
    public void deleteWorker(Worker worker) {
        workerRepository.delete(worker);
    }

    @Override
    public Worker getWorkerByEmail(String email) {
        return workerRepository.findByEmail(email);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public List<Worker> getWorkersBySchool(School school) {
        return workerRepository.findBySchool(school);
    }

    @Override
    public List<Worker> getWorkersByCourse(Course course) {
        return workerRepository.findByCoursesCourse(course);
    }
}
