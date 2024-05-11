package com.example.post.service;

import com.example.post.global.domain.entity.Category;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.CategoryRepository;
import com.example.post.global.domain.repository.UserBlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserBlogRepository userBlogRepository;

    @Override
    public List<Category> getAllByUserId(UUID userId) {
        Optional<UserBlog> userById = userBlogRepository.findById(userId);
        UserBlog userBlog = userById.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
        List<Category> categories = categoryRepository.findAllByUserBlog(userBlog);
        return categories;
    }

    @Override
    public void create(String categoryName, UUID userId) {
        Optional<UserBlog> userById = userBlogRepository.findById(userId);
        if (userById.isEmpty()) throw new IllegalArgumentException("유저가 존재하지 않습니다.");
        Category category = Category.builder().categoryName(categoryName).userBlog(userById.get()).build();
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void update(Long id, String categoryName) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) throw new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.");
        byId.get().setCategoryName(categoryName);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
