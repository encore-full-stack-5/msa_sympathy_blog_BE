package com.example.post.global.domain.entity;


import com.example.post.global.domain.type.PublicScope;

import com.example.post.global.domain.type.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "POSTS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @Column(name="POST_TITLE", nullable = false) @Setter
    private String title;

    @Column(name="POST_CONTENT", nullable = false) @Setter
    private String content;


    @Column(name="POST_PUBLIC_SCOPE", nullable = false) @Setter
    @Enumerated(EnumType.STRING)
    private PublicScope publicScope;


    @Column(name="POST_CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @ManyToOne
    private Category category;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserBlog userBlog;


    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL) @Setter
    private PostView postView;

    @Column(name="POST_TOPIC", nullable = false) @Setter
    @Enumerated(EnumType.STRING)
    private Topic topic;
}
