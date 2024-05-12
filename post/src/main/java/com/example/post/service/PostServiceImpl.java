package com.example.post.service;

import com.example.post.dto.request.PostRequest;
import com.example.post.dto.response.PostResponse;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.PostLove;
import com.example.post.global.domain.entity.PostView;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.PostLoveRepository;
import com.example.post.global.domain.repository.PostRepository;
import com.example.post.global.domain.repository.PostViewRepository;
import com.example.post.global.domain.repository.UserBlogRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final PostViewRepository postViewRepository;
    private final PostLoveRepository postLoveRepository;
    private final UserBlogRepository userBlogRepository;
    @Override
    public void save(PostRequest postRequest) {
        PostView postView = PostView.builder()
                .post(postRequest.toEntity()).build();
        postViewRepository.save(postView);
        postRequest.toEntity().setPostView(postView);
        postView.setView(0);
        postRepository.save(postRequest.toEntity());

        // post 생성과 동시에 postLike post 당 1개 배정
        UserBlog userBlog = userBlogRepository
                .findById(postRequest.userId())
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
        PostLove postLove = PostLove.builder().post(postRequest.toEntity()).userBlog(userBlog).build();
        postLoveRepository.save(postLove);

//        PostView postView = new PostView();
//        postView.setPost(post);
//        postView.setView(0);
//        postViewRepository.save(postView);
    }

    @Override
    public Post update(PostRequest req, Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                EntityNotFoundException::new);
        post.setContent(req.content());
        post.setTitle(req.title());
//        post.setMediaPosts(req.toEntity().getMediaPosts()); // MediaPost table 삭제
        postRepository.save(post);
        return post;
    }

    @Override
    public PostResponse getPostById(Long id) {
        PostResponse post = PostResponse.from(postRepository.findById(id).orElseThrow(EntityNotFoundException::new));
        return post;
    }

//    pageable이 뭘까?
    @Override
    public Page<PostResponse> getPostsByUserId(Pageable pageable, UUID userId) {
        Page<Post> posts = postRepository.findAllByUserBlog_Id(pageable, userId);
        return posts.map(PostResponse::from);
    }
}
