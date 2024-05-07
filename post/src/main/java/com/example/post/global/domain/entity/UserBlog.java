package com.example.post.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "USER_BLOGS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name="USER_NICKNAME", nullable = false)
    private String nickname;
    @OneToMany(mappedBy = "userBlog")
    private List<Post> posts;
}
