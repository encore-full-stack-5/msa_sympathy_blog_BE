package com.example.user.global.domain.entity;


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
@Table(name = "NEIGHBORS")
public class Neighbor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEIGHBOR_ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "REQUEST_ID")
    private Long requestUserId;

    @Column(name = "RESPONSE_ID")
    private Long responseUserId;

    @Column(name = "STATUS")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "USER_BLOG_ID")
    private UserBlog userBlog;

}
