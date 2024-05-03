package com.example.post.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name= "POSTS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder`
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;
    @Column(name="POST_TITLE", nullable = false)
    private String title;
    @Column(name="POST_CONTENT", nullable = false)
    private String content;
    @Column(name="POST_PUBLIC_SCOPE", nullable = false)
    private String publicScope;
    @Column(name="POST_CREATED_AT", nullable = false)
    private LocalDateTime createdAt;
    @Column(name="USER_ID")
    private Long userId;
}
