package com.example.post.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "MEDIA_POSTS")
public class MediaPost {

    @Id
    @Column(name = "MEDIA_POST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "POST_ID")
    @ManyToOne
    private Post post;

    @JoinColumn(name = "MEDIA_ID")
    @ManyToOne
    private Media media;
}
