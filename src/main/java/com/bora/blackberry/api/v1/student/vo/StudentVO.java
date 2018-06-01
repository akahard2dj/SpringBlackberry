package com.bora.blackberry.api.v1.student.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentVO {

    private long id;
    private String nickName;
    private String emailAddress;
    private String universityName;
}
