package com.example.post.global.domain.repository;

import com.example.post.global.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByUserId(Long userId);
}
