package com.bora.blackberry.domain.student.service;

import com.bora.blackberry.api.v1.student.form.StudentRegistrationForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Transactional
    public long register(StudentRegistrationForm form) {

        return -1;
    }
}
