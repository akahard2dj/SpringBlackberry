package com.bora.blackberry.api.v1.domain.article.entity;

import com.bora.blackberry.api.v1.domain.constant.IsType;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Column(length = 2000)
    private String body;

    private long boardId;
    private long hitsCount;
    private long likesCount;
    private long dislikeCount;

    @Column(length = 1)
    @Enumerated(value = EnumType.STRING)
    private IsType deleted;
    @Column(length = 1)
    @Enumerated(value = EnumType.STRING)
    private IsType reported;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
