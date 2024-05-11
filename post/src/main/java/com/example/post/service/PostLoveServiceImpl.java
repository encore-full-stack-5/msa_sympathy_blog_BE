package com.example.post.service;

import com.example.post.dto.response.LoveResponse;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.PostLove;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.PostLoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLoveServiceImpl implements PostLoveService {

    private final PostLoveRepository postLoveRepository;

    // post를 생성하면 바로 새로운 like entity를 만들어준다. (like = false로 해서)

    @Override
    public Long countLike(Post post) {
        Optional<Long> byPostId = postLoveRepository.countByPostId(post.getId());
        Long count = byPostId.orElseGet(() -> 0L);
        return count;
    }

    @Override
    public void updateLike(Post post, UserBlog userBlog) {
        PostLove postLove = postLoveRepository
                .findByPostIdAndUserBlogId(post.getId(), userBlog.getId())
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        postLove.setLove(!postLove.isLove());
        // click하고 love true/false는 front 에서 알아서 바꿈
    }

    @Override
    public List<LoveResponse> getLovers(Post post) {
        List<PostLove> postLoves = postLoveRepository.findByPostIdAndLove(post.getId(), true);
        if (postLoves.isEmpty()) throw new NullPointerException("공감 해주세요!"); // front에서 null이면 없음을 보여줌
        List<LoveResponse> list = new ArrayList<>();
        postLoves.forEach((el) -> {
            LoveResponse loveResponse = new LoveResponse(el.getUserBlog().getNickname(), el.getPost().getTitle());
            list.add(loveResponse);
        });
        return list;
    }
}
