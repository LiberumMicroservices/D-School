package com.school.data.entity.workers.service;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.workers.Worker;

import java.util.List;

public interface WorkerService {
    Worker addWorker(Worker worker);
    Worker editWorker(Worker worker);
    void deleteWorker(long id);
    void deleteWorker(Worker worker);
    Worker getWorkerByEmail(String email);
    List<Worker> getAllWorkers();
    List<Worker> getWorkersBySchool(School school);
    List<Worker> getWorkersByCourse(Course course);
}
