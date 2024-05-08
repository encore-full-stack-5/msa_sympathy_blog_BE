package com.example.user.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "VISITORS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VISITOR_ID")
    private Long id;
    @Column(name = "VISITORS_CREATEDAT")
    private LocalDateTime createdAt;
    @Column(name = "VISITOR_USERID")
    private Long userId;

}
