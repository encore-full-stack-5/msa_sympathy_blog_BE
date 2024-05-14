package com.example.comment.service.d1;

import com.example.comment.dto.request.CommentLikeRequest;
import com.example.comment.dto.request.CommentRequest;
import com.example.comment.global.domain.entity.Comment;
import com.example.comment.global.domain.entity.CommentLike;
import com.example.comment.global.domain.repository.CommentRepository;
import com.example.comment.service.d2.CommentLikeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

//한서비스에 한레포먼 쓰이는게좋음
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentLikeService commentLikeService;


    @Override
    public void saveComment(CommentRequest request) {
        commentRepository.save(request.toEntity());

    }

    @Override
    public void updateComment(CommentRequest request, Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        Comment updatedComment = request.toEntity();
        commentRepository.save(updatedComment);

    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment getCommentId(Long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void commentLike(CommentLike commentLike) {

        Optional<Comment> byCommentId = commentRepository.findById(commentLike.getComment().getId());
        Comment comment = byCommentId.orElseThrow(()-> new RuntimeException("Comment not found"));

        comment.setLikeCount(comment.getLikeCount() +
                commentLikeService.likeComment(comment, commentLike.getUserId()));

    }

    @Override
    public int getCommentLikeTotalByCommentId(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if (comment.getCommentLikes() == null) {throw new RuntimeException("like cannot ne null");}



        Integer likeCount = comment.getLikeCount();
        return likeCount != null ? likeCount.intValue() : 0;
    }


}
