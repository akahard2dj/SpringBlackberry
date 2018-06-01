package com.bora.blackberry.api.v1.university.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UniversityRegistrationForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String emailPostfix;
}
