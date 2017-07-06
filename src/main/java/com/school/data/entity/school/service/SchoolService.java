package com.school.data.entity.school.service;

import com.school.data.entity.school.School;

import java.util.List;

public interface SchoolService {
    School addSchool(School school);
    void deleteSchool(long id);
    void deleteSchool(School school);
    School editSchool(School school);
    List<School> getSchoolByName(String name);
    List<School> getAllSchool();

}
