package com.practice.efubaccount.account.controller;

import com.practice.efubaccount.account.dto.response.AccountCommentResponse;
import com.practice.efubaccount.account.service.AccountsService;
import com.practice.efubaccount.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// week4 실습 코드 추가
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts/{accountId}/comments")
public class AccountCommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<AccountCommentResponse>getAccountComments(@PathVariable("accountId") Long accountId) {
        return ResponseEntity.ok(commentService.getAccountCommentList(accountId));
    }
}
