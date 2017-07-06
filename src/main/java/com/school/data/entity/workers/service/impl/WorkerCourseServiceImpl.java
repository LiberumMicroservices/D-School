package com.school.data.entity.workers.service.impl;

import com.school.data.entity.courses.Course;
import com.school.data.entity.workers.WorkerCourse;
import com.school.data.entity.workers.repository.WorkerCourseRepository;
import com.school.data.entity.workers.service.WorkerCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerCourseServiceImpl implements WorkerCourseService {

    @Autowired
    private WorkerCourseRepository workerCourseRepository;

    @Override
    public WorkerCourse addWorkerCourse(WorkerCourse workerCourse) {
        return workerCourseRepository.saveAndFlush(workerCourse);
    }

    @Override
    public WorkerCourse editWorkerCourse(WorkerCourse workerCourse) {
        return workerCourseRepository.saveAndFlush(workerCourse);
    }

    @Override
    public void deleteWorkerCourse(long id) {
        workerCourseRepository.delete(id);
    }

    @Override
    public void deleteWorkerCourse(WorkerCourse workerCourse) {
        workerCourseRepository.delete(workerCourse);
    }

    @Override
    public List<WorkerCourse> getAllWorkerCourse() {
        return workerCourseRepository.findAll();
    }

    @Override
    public List<WorkerCourse> getWorkerCourseByCourse(Course course) {
        return workerCourseRepository.findByCourse(course);
    }
}
