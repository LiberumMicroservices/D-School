package com.school.data.entity.students.repository;

import com.school.data.entity.students.ResponsiblePerson;
import com.school.data.entity.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResponsiblePersonRepository extends JpaRepository<ResponsiblePerson, Long> {

    List<ResponsiblePerson> findByStudent(@Param("student") Student student);
}
