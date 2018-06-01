package com.bora.blackberry.domain.student.service;

import com.bora.blackberry.api.v1.student.form.StudentRegistrationForm;
import com.bora.blackberry.api.v1.student.vo.StudentVO;
import com.bora.blackberry.domain.constant.IsType;
import com.bora.blackberry.domain.student.entity.Student;
import com.bora.blackberry.domain.student.repository.StudentRepository;
import com.bora.blackberry.domain.university.entity.University;
import com.bora.blackberry.domain.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityService universityService;

    public StudentVO findById(long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;

        University university = universityService.findById(student.getUniversityId());
        String emailAddress = student.getEmailPrefix() + "@"+ university.getEmailPostfix();
        String universityName = university.getName();
        return new StudentVO(student.getId(), student.getNickName(), emailAddress, universityName);
    }

    @Transactional
    public long register(StudentRegistrationForm form) {

        Student student = Student.builder()
                .emailPrefix(form.getEmailPrefix())
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
