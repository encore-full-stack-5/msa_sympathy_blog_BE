package com.example.post.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
@Table(name = "POST_CATEGORYS")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRIDGE_ID")
    private int bridgeId;
    @Column(name = "CATEGORY_ID")
    private int categoryId;
    @Column(name = "POST_ID")
    private int postId;


}
