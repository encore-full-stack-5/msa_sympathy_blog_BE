package com.example.post.global.domain.repository;

import com.example.post.global.domain.entity.UserBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBlogRepository extends JpaRepository<UserBlog,Long> {
}
