package com.example.post.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "POST_LIKES")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_LIKE_ID")
    private Long id;

    @Column(name = "LIKE")
    @Setter
    private boolean like;

    // 객체로 받는다. 공감한 사람들을 보여줄 때 사용하기 때문에
    @JoinColumn(name = "POST_ID")
    @ManyToOne
    private Post post;

    // 객체로 받는다. 공감한 사람들을 보여줄 때 사용하기 때문에
    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private UserBlog user;
}
