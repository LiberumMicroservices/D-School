package com.school.data.entity.workers.service;

import com.school.data.entity.courses.Course;
import com.school.data.entity.workers.WorkerCourse;

import java.util.List;

public interface WorkerCourseService {
    WorkerCourse addWorkerCourse(WorkerCourse workerCourse);
    WorkerCourse editWorkerCourse(WorkerCourse workerCourse);
    void deleteWorkerCourse(long id);
    void deleteWorkerCourse(WorkerCourse workerCourse);
    List<WorkerCourse> getAllWorkerCourse();
    List<WorkerCourse> getWorkerCourseByCourse(Course course);
}
