package com.bora.blackberry.domain.university.repository;

import com.bora.blackberry.domain.university.entity.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityRepository extends CrudRepository<University, Long> {

    University findById(long id);
    List<University> findAll();
}
