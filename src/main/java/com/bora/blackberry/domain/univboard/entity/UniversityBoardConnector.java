package com.bora.blackberry.domain.univboard.entity;

import com.bora.blackberry.domain.constant.IsType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UniversityBoardConnector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private long universityId;

    @Column(nullable = false, unique = true)
    private long boardId;

    @Column(length = 1, columnDefinition = "ENUM('Y', 'N') NOT NULL DEFAULT 'N'")
    @Enumerated(value = EnumType.STRING)
    private IsType deleted;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW()")
    private LocalDateTime updatedAt;
}
