package com.example.post.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "MEDIAS")
public class Media {

    @Id
    @Column(name = "MEDIA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PATH")
    private String path;

    @Column(name ="MEDIA_POST_ID")
    @OneToMany(mappedBy = "media")
    private List<MediaPost> mediaPosts;
}
