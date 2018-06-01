package com.bora.blackberry.api.v1.student.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRegistrationForm {

    private int universityCode;
    private String password;
    private String nickName;
}
