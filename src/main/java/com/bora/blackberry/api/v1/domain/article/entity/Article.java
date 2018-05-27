package com.bora.blackberry.api.v1.domain.article.entity;

import com.bora.blackberry.api.v1.domain.constant.IsType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(length = 1, columnDefinition = "ENUM('Y', 'N') NOT NULL DEFAULT 'N'")
    @Enumerated(value = EnumType.STRING)
    private IsType deleted;
    @Column(length = 1, columnDefinition = "ENUM('Y', 'N') NOT NULL DEFAULT 'N'")
    @Enumerated(value = EnumType.STRING)
    private IsType reported;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW()")
    private LocalDateTime updatedAt;
}
