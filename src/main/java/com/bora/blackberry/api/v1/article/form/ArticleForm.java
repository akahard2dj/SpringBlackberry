package com.bora.blackberry.api.v1.article.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ArticleForm {

    @NotEmpty
    private String title;
    @NotEmpty
    private String body;
}
