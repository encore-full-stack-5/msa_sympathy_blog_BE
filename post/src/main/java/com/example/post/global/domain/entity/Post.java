package com.example.post.global.domain.entity;

import com.example.post.global.domain.type.PublicScope;
import com.example.post.global.domain.type.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name="POST_TITLE", nullable = false)
    private String title;

    @Column(name="POST_CONTENT", nullable = false)
    private String content;

    @Column(name="POST_PUBLIC_SCOPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PublicScope publicScope;

    @Column(name="POST_CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @ManyToOne
    private Category category;

    @JoinColumn(name = "USER_BLOG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserBlog userBlog;

//    mapping table 삭제로 필요 없어짐
//    @Column(name ="MEDIA_POST_ID")
//    @OneToMany(mappedBy = "post")
//    private List<MediaPost> mediaPosts;
//
    @OneToOne
    @JoinColumn(name = "POST_VIEW_ID")
    private PostView postView;

    @Column(name = "TOPIC")
    @Enumerated(EnumType.STRING)
    private Topic topic;
}
