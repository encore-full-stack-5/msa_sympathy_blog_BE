package com.example.user.global.domain.repository;

import com.example.user.dto.request.VisitorRequest;
import com.example.user.global.domain.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
        List<Visitor> findByUserBlogId(UUID userBlogId);
}