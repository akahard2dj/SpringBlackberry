package com.bora.blackberry.domain.university.service;

import com.bora.blackberry.api.v1.university.form.UniversityRegistrationForm;
import com.bora.blackberry.domain.constant.IsType;
import com.bora.blackberry.domain.university.entity.University;
import com.bora.blackberry.domain.university.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public University findById(long universityId) {
        return universityRepository.findById(universityId);
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Transactional
    public long register(UniversityRegistrationForm form) {
        University university = University.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .deleted(IsType.N)
                .emailPostfix(form.getEmailPostfix())
                .name(form.getName())
                .build();

        return universityRepository.save(university).getId();
    }

}
