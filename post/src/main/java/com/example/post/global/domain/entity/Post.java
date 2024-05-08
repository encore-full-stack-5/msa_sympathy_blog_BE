package com.example.post.global.domain.entity;

import com.example.post.global.domain.type.PublicScope_buja;
import com.example.post.global.domain.type.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    private PublicScope_buja publicScope;

    @Column(name="POST_TOPIC", nullable = false) @Setter
    private Topic topic;

    @Column(name="POST_CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="POST_CATEGORY_ID")
    @OneToMany(mappedBy = "post")
    private List<PostCategory> postCategories;

    @JoinColumn(name = "USER_BLOG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserBlog userBlog;

    @Column(name ="MEDIA_POST_ID") @Setter
    @OneToMany(mappedBy = "post")
    private List<MediaPost> mediaPosts;

    @OneToOne
    @JoinColumn(name = "POST_VIEW_ID") @Setter
    private PostView postView;
}
