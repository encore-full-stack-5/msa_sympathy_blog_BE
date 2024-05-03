package com.example.comment.global.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name ="COMMENTS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="COMMENT_ID")
    private Long id;
    @Column(name="COMMENT_CREATED_AT", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "POST_ID")
    private Long postId;
    @Column(name = "USER_ID")
    private Long userId;


}
