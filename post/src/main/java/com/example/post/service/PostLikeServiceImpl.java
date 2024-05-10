package com.example.post.service;

import com.example.post.dto.response.LikeResponse;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.PostLike;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService {

    private final PostLikeRepository postLikeRepository;

    // post를 생성하면 바로 새로운 like entity를 만들어준다. (like = false로 해서)

    @Override
    public Long countLike(Post post) {
        Optional<Long> byPostId = postLikeRepository.countByPostId(post.getId());
        Long count = byPostId.orElseGet(() -> 0L);
        return count;
    }

    @Override
    public void updateLike(Post post, UserBlog user) {
        Optional<PostLike> byPostIdAndUserId = postLikeRepository
                .findByPostIdAndUserId(post.getId(), user.getId());
        // else case가 발생할 일이 없다.
        PostLike postLike = byPostIdAndUserId.get();
        postLike.setLike(!postLike.isLike());
        // click하고 like true/false는 front 에서 알아서 바꿈
    }

    @Override
    public List<LikeResponse> getLiker(Post post) {
        List<PostLike> postLikes = postLikeRepository.findByPostIdAndLike(post.getId(), true);
        if (postLikes.isEmpty()) throw new NullPointerException("공감 해주세요!"); // front에서 null이면 없음을 보여줌
        List<LikeResponse> list = new ArrayList<>();
        postLikes.forEach((el) -> {
            LikeResponse likeResponse = new LikeResponse(el.getUser().getNickname(), el.getPost().getTitle());
            list.add(likeResponse);
        });
        return list;
    }
}
