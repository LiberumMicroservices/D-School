package com.school.data.entity.school.repository;

import com.school.data.entity.school.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    @Query("select s from School s where s.name = :name")
    List<School> findByName(@Param("name") String name);
}
