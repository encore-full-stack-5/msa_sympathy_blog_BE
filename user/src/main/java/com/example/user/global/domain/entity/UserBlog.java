package com.example.user.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER_BLOGS")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @Builder
public class UserBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "BLOG_NAME")
    private String blogName;
}
