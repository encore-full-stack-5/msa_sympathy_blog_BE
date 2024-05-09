package com.example.post.service;

import com.example.post.dto.request.PostRequest;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.PostView;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.PostRepository;
import com.example.post.global.domain.repository.PostViewRepository;
import com.example.post.global.domain.repository.UserBlogRepository;
import com.example.post.global.domain.type.PublicScope_buja;
import com.example.post.global.domain.type.Topic;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostViewRepository postViewRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserBlogRepository userBlogRepository;
    @Test
    void save() {
        Post init = Post.builder()
                .title("title")
                .content("content")
                .userBlog(UserBlog.builder()
                        .id(UUID.fromString("e97db8b3-a63e-4750-85d2-9705b7aa2749"))
                        .build())
                .createdAt(LocalDateTime.now())
                .publicScope(PublicScope_buja.valueOf("FULL"))
                .topic(Topic.valueOf("LIFE"))
                .build();

        postRepository.save(init);

        PostView postView = new PostView();
        postView.setPost(init);
        postView.setView(0);
        postViewRepository.save(postView);
        assertEquals(init.getTitle(), "title");
        assertEquals(0,postViewRepository.findById(1L).get().getView());
    }

    @Test
    void update_성공() {
        Post init = Post.builder()
                .title("title")
                .content("content")
                .createdAt(LocalDateTime.now())
                .publicScope(PublicScope_buja.valueOf("FULL"))
                .topic(Topic.valueOf("LIFE"))
                .build();
        postRepository.save(init);

        Post byId = postRepository.findById(1L).get();
        byId.setTitle("updated");

        assertEquals(byId.getTitle(), "updated");
    }

    @Test
    void update_실패() {
        Post init = Post.builder()
                .title("title")
                .content("content")
                .createdAt(LocalDateTime.now())
                .publicScope(PublicScope_buja.valueOf("FULL"))
                .topic(Topic.valueOf("LIFE"))
                .build();
        postRepository.save(init);
        PostRequest req = new PostRequest("title", "dfsdf",
                UUID.randomUUID(),
                "ddd","LIFE","FULL");
        assertThrows(EntityNotFoundException.class,
                () -> postService.update(req,100L));
    }

    @Test
    void getPostById_실패() {
        assertThrows(EntityNotFoundException.class,
                () -> postService.getPostById(100L));
    }

    @Test
    void getPostById_성공() {
        Post init = Post.builder()
                .title("title")
                .content("content")
                .createdAt(LocalDateTime.now())
                .publicScope(PublicScope_buja.valueOf("FULL"))
                .topic(Topic.valueOf("LIFE"))
                .build();
        postRepository.save(init);

        Post byId = postRepository.findById(1L).get();
        assertEquals(byId.getTitle(), "title");
    }

    @Test
    @Transactional
    void getPostsByUserId() {
        UUID userId = UUID.fromString("e97db8b3-a63e-4750-85d2-9705b7aa2749");
        Pageable pageable = PageRequest.of(0, 5);

        // 새로운 UserBlog 객체 생성 및 저장
        UserBlog user = UserBlog.builder()
                .id(userId)
                .nickname("test")
                .build();

        for (Long i = 0L; i < 5; i++) {
            // PostView 엔티티를 먼저 생성하고 저장
            PostView postView = new PostView();
            postView.setView(0);
            postViewRepository.save(postView);

            // Post 엔티티 생성 후에 postView 속성에 저장한 PostView 엔티티 설정
            Post init = Post.builder()
                    .title("title"+i)
                    .content("content")
                    .createdAt(LocalDateTime.now())
                    .publicScope(PublicScope_buja.valueOf("FULL"))
                    .topic(Topic.valueOf("LIFE"))
                    .userBlog(user)
                    .postView(postView) // Post 엔티티의 postView 속성 설정
                    .build();
            postRepository.save(init);
        }

        // 사용자 ID를 기반으로 게시물을 가져와서 검증
        assertEquals(5, postService.getPostsByUserId(pageable, userId).get().toList().size());
    }
}