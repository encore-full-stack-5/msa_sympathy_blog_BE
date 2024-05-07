package com.example.comment.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="LIKES")
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIKE_ID")
    private Long id;
    @Column(name = "IS_LIKED")
    Boolean isLiked;
    @Column(name = "POST_ID")
    Long postId;
    @Column(name = "USER_ID")
    Long userId;

}
