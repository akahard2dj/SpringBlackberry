package com.bora.blackberry.api.v1.student.controller;

import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.api.v1.student.form.StudentRegistrationForm;
import com.bora.blackberry.domain.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "학생")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    @ApiOperation(value = "학생 가입", notes = "학생 가입")
    public ResponseWrapper register(@RequestBody StudentRegistrationForm form) {
        return ResponseWrapper.ok(studentService.register(form));
    }
}
