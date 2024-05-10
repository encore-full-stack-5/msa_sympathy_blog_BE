package com.example.post.service;

import com.example.post.global.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllByUserId(Long userId);
    void create(String categoryName, Long userId);
    void update(Long id, String categoryName);
    void delete(Long id);
}
