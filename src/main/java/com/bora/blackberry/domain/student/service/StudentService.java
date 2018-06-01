package com.bora.blackberry.domain.student.service;

import com.bora.blackberry.api.v1.student.form.StudentRegistrationForm;
import com.bora.blackberry.domain.constant.IsType;
import com.bora.blackberry.domain.student.entity.Student;
import com.bora.blackberry.domain.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public long register(StudentRegistrationForm form) {

        Student student = Student.builder()
                .emailPostfix(form.getEmailPostfix())
                .universityId(form.getUniversityId())
                .nickName(form.getNickName())
                .password(form.getPassword()) // hashing 필요
                .deleted(IsType.N)
                .reported(IsType.N)
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();

        return studentRepository.save(student).getId();
    }
}
