package com.bora.blackberry.domain.Student.entity;

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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long universityId;

    @Column(nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String password;

    @Column(length = 1, columnDefinition = "ENUM('Y', 'N') NOT NULL DEFAULT 'N'")
    @Enumerated(value = EnumType.STRING)
    private IsType deleted;

    @Column(length = 1, columnDefinition = "ENUM('Y', 'N') NOT NULL DEFAULT 'N'")
    @Enumerated(value = EnumType.STRING)
    private IsType reported;

    private String reportedReason;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW()")
    private LocalDateTime updatedAt;

}
