package com.bora.blackberry.domain.university.entity;

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
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String emailPostfix; // e.g) snu.ac.kr

    @Column(length = 1, columnDefinition = "ENUM('Y', 'N') NOT NULL DEFAULT 'N'")
    @Enumerated(value = EnumType.STRING)
    private IsType deleted;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW()")
    private LocalDateTime updatedAt;
}
