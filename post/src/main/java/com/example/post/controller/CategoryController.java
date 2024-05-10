package com.example.post.controller;

import com.example.post.global.domain.entity.Category;
import com.example.post.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping // token 이용
    public List<Category> getAllByUserId(Long userId) {
        return categoryService.getAllByUserId(userId);
    }

    @PostMapping // token 이용
    public void create(@RequestBody String categoryName, Long userId) {
        categoryService.create(categoryName, userId);
    }

    @PutMapping
    public void update(@RequestParam Long id, @RequestBody String categoryName) {
        categoryService.update(id, categoryName);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        categoryService.delete(id);
    }
}
