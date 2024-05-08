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
@Table(name = "POST_VIEWS")
public class PostView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_VIEW_ID")
    private Long id;
    @Column(name = "VIEW")
    private Integer view;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "POST_ID")
    private Post post;
}
