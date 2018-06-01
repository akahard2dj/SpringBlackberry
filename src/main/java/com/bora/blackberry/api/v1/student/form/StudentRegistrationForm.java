package com.bora.blackberry.api.v1.student.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class StudentRegistrationForm {

    @Min(0)
    private int universityId;

    @NotEmpty
    private String emailPrefix;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickName;
}
