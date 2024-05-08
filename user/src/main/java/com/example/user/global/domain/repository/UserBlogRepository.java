package com.example.user.global.domain.repository;

import com.example.user.global.domain.entity.UserBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBlogRepository extends JpaRepository<UserBlog,Long> {
}
