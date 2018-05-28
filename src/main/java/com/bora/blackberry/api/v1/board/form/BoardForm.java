package com.bora.blackberry.api.v1.board.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BoardForm {

    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
}
