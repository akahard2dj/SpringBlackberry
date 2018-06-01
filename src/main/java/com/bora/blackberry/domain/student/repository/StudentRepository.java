package com.bora.blackberry.domain.student.repository;

import com.bora.blackberry.domain.student.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
