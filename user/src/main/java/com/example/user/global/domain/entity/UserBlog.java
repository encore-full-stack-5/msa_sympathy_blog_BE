package com.example.user.global.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "USER_BLOGS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class UserBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_BLOG_ID")
    private Long id;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "BLOG_NAME")
    private String blogName;

    @Column(name="POST_ID")
    private Long postId;

    @Column(name="NEIGHBOR_ID")
    @OneToMany(mappedBy = "userBlog")
    private List<Neighbor> neighbors;

}
