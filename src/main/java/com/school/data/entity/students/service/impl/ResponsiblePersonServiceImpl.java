package com.school.data.entity.students.service.impl;

import com.school.data.entity.students.ResponsiblePerson;
import com.school.data.entity.students.Student;
import com.school.data.entity.students.repository.ResponsiblePersonRepository;
import com.school.data.entity.students.service.ResponsiblePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsiblePersonServiceImpl implements ResponsiblePersonService{

    @Autowired
    private ResponsiblePersonRepository responsiblePersonRepository;

    @Override
    public ResponsiblePerson addResponsiblePerson(ResponsiblePerson responsiblePerson) {
        return responsiblePersonRepository.saveAndFlush(responsiblePerson);
    }

    @Override
    public void deleteResponsiblePerson(long id) {
        responsiblePersonRepository.delete(id);
    }

    @Override
    public void deleteResponsiblePerson(ResponsiblePerson responsiblePerson) {
        responsiblePersonRepository.delete(responsiblePerson);
    }

    @Override
    public ResponsiblePerson editResponsiblePerson(ResponsiblePerson responsiblePerson) {
        return responsiblePersonRepository.saveAndFlush(responsiblePerson);
    }

    @Override
    public List<ResponsiblePerson> getAllResponsiblePerson() {
        return responsiblePersonRepository.findAll();
    }

    @Override
    public List<ResponsiblePerson> getResponsiblePersonByStudent(Student student) {
        return responsiblePersonRepository.findByStudent(student);
    }
}
