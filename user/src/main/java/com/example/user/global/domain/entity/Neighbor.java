package com.example.user.global.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "NEIGHBORS")
public class Neighbor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "NEIGHBOR_ID")
    private UUID id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "REQUEST_ID")
    private UUID requestUserId;

    @Column(name = "RESPONSE_ID")
    private UUID responseUserId;

    @Column(name = "STATUS")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "USER_BLOG_ID")
    private UserBlog userBlog;

}
