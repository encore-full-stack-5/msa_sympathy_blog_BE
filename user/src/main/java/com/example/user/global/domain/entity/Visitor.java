package com.example.user.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "VISITORS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "VISITOR_ID")
    private UUID id;
    @Column(name = "VISITORS_CREATEDAT")
    private LocalDateTime createdAt;
    @Column(name = "VISITOR_USERID")
    private UUID userId;

}
