package com.example.user.dto.request;

import com.example.user.global.domain.entity.Visitor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record VisitorRequest(

        String userBlogId

) {
    public Visitor toEntity(){

        return Visitor.builder()
                .userBlogId(UUID.fromString(userBlogId))
                .build();
    }

}
