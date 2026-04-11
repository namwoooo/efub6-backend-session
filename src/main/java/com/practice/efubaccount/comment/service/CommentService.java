package com.practice.efubaccount.comment.service;

import com.practice.efubaccount.account.dto.response.AccountCommentResponse;
import com.practice.efubaccount.comment.dto.request.CommentRequest;
import com.practice.efubaccount.global.exception.CustomException;
import com.practice.efubaccount.global.exception.ErrorCode;
import com.practice.efubaccount.post.dto.response.PostCommentResponse;
import com.practice.efubaccount.account.dto.response.AccountCommentResponse;
import com.practice.efubaccount.account.domain.Account;
import com.practice.efubaccount.account.repository.AccountsRepository;
import com.practice.efubaccount.account.service.AccountsService;
import com.practice.efubaccount.comment.domain.Comment;
import com.practice.efubaccount.comment.dto.request.CommentRequest;
import com.practice.efubaccount.comment.repository.CommentRepository;
import com.practice.efubaccount.post.domain.Post;
import com.practice.efubaccount.post.dto.response.PostCommentResponse;
import com.practice.efubaccount.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final AccountsService accountsService;
    private final PostService postService;
    private final CommentRepository commentRepository;

    @Transactional
    public Long createComment(Long postId, CommentRequest request) {
        Long accountId = request.getAccountId();
        Account writer = accountsService.findByAccountId(accountId);
        Post post = postService.findByPostId(postId);
        Comment newComment = request.toEntity(writer, post);
        commentRepository.save(newComment);
        return newComment.getId();
    }

    @Transactional
    public PostCommentResponse getPostCommentList(Long postId) {
        List<Comment> commentList = commentRepository.findAllByPostIdOrderByCreatedAt(postId);
        return PostCommentResponse.of(postId,commentList);
    }

    @Transactional(readOnly=true)
    public AccountCommentResponse getAccountCommentList(Long accountId) {
        Account account = accountsService.findByAccountId(accountId);
        List<Comment> commentList = commentRepository.findAllByWriterAccountIdOrderByCreatedAtDesc(accountId);
        return AccountCommentResponse.of(account, commentList);
    }

}
