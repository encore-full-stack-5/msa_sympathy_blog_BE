package com.example.user.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
@Table( name = "TODAY")
public class Today {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( name = "TODAY_ID")
    private UUID id;
    @Column( name = "COUNT")
    private int count;
    @Column( name = "DATE")
    private LocalDateTime date;
    @Column( name = "USER_ID")
    private UUID userId;


}
