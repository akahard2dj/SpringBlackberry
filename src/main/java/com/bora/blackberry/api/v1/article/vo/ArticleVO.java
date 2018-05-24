package com.bora.blackberry.api.v1.article.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ArticleVO {

    private long id;
    private String title;
    private String body;
    private long hitsCount;
    private long likesCount;
    private long dislikeCount;
    private LocalDateTime createdAt;
}
