package com.school.data.entity.students.service;

import com.school.data.entity.students.ResponsiblePerson;
import com.school.data.entity.students.Student;

import java.util.List;

public interface ResponsiblePersonService {
    ResponsiblePerson addResponsiblePerson(ResponsiblePerson responsiblePerson);
    void deleteResponsiblePerson(long id);
    void deleteResponsiblePerson(ResponsiblePerson responsiblePerson);
    ResponsiblePerson editResponsiblePerson(ResponsiblePerson responsiblePerson);
    List<ResponsiblePerson> getAllResponsiblePerson();
    List<ResponsiblePerson> getResponsiblePersonByStudent(Student student);
}
