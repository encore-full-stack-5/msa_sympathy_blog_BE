package com.example.user.global.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "NEIGHBOR")
public class Neighbor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEIGHBOR_ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @JoinColumn(name = "USER_ID") // 이렇게 할 수 있나?
    @ManyToOne
    private User requestingUser; // 이웃 요청 하는 사람

    @JoinColumn(name = "USER_ID")   // // 이렇게 할 수 있나?
    @ManyToOne
    private User requestedUser; // 이웃 요청 받는 사람

    @Column(name = "STATUS")
    private Boolean status;

}
