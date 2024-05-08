package com.example.post.global.domain.repository;

import com.example.post.global.domain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findAllByUserBlog_Id(Pageable pageable, String userId);
}
