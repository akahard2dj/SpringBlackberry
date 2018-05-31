package com.bora.blackberry.api.v1.article.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ArticleSimpleVO {

    private long id;
    private String title;
    private long hitsCount;
    private long likesCount;
    private long dislikeCount;
    private LocalDateTime createdAt;
}
