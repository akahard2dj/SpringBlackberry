package com.bora.blackberry.api.v1.university.controller;

import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.api.v1.university.form.UniversityRegistrationForm;
import com.bora.blackberry.api.v1.university.vo.UniversityVO;
import com.bora.blackberry.domain.university.entity.University;
import com.bora.blackberry.domain.university.service.UniversityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "대학교")
@RestController
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/universities")
    @ApiOperation(value = "대학교 리스트 조회", notes = "대학교 리스트 조회")
    public ResponseWrapper getAllUniversities() {

        List<University> universityList = universityService.getAllUniversities();
        return ResponseWrapper.ok(
                universityList.stream().map(u -> modelMapper.map(u, UniversityVO.class))
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/universities")
    @ApiOperation(value = "대학교 등록", notes = "대학교 등록")
    public ResponseWrapper register(@Valid @RequestBody UniversityRegistrationForm form) {

        return ResponseWrapper.ok(universityService.register(form));
    }
}
