package com.example.post.service;

import com.example.post.global.domain.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllByUserId(UUID userId);
    void create(String categoryName, UUID userId);
    void update(Long id, String categoryName);
    void delete(Long id);
}
