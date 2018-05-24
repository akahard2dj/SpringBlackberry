package com.bora.blackberry.api.v1.domain.article.entity;

import com.bora.blackberry.api.v1.domain.constant.IsType;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String body;

    @Column(name = "board_id")
    private long boardId;
    @Column(name = "hits_count")
    private long hitsCount;
    @Column(name = "likes_count")
    private long likesCount;
    @Column(name = "dislike_count")
    private long dislikeCount;

    @Enumerated(value = EnumType.STRING)
    private IsType deleted;
    @Enumerated(value = EnumType.STRING)
    private IsType reported;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
