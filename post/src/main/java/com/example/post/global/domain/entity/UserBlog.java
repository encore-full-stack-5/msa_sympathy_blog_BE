package com.example.post.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "USER_BLOGS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBlog {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name="USER_NICKNAME", nullable = false)
    private String nickname;
    @OneToMany(mappedBy = "userBlog")
    private List<Post> posts;
}
