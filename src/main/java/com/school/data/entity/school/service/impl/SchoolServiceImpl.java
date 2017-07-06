package com.school.data.entity.school.service.impl;

import com.school.data.entity.school.School;
import com.school.data.entity.school.repository.SchoolRepository;
import com.school.data.entity.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School addSchool(School school) {
        return schoolRepository.saveAndFlush(school);
    }

    @Override
    public void deleteSchool(long id) {
        schoolRepository.delete(id);
    }

    @Override
    public void deleteSchool(School school) {
        schoolRepository.delete(school);
    }

    @Override
    public School editSchool(School school) {
        return schoolRepository.saveAndFlush(school);
    }

    @Override
    public List<School> getSchoolByName(String name) {
        return schoolRepository.findByName(name);
    }

    @Override
    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }
}
