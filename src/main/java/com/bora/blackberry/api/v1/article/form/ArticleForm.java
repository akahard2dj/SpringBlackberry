package com.bora.blackberry.api.v1.article.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ArticleForm {

    @NotEmpty
    @Size(min = 1, max = 30)
    private String title;

    @NotEmpty
    @Size(min = 10, max = 1000)
    private String body;
}
