package com.example.user.global.domain.repository;

import com.example.user.global.domain.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {
}
