package com.practice.efubaccount.comment.domain;

import com.practice.efubaccount.account.domain.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLike {

    @Id
    @Column(name = "comment_like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)     // comment의 comment_id를 FK로 가져옴
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    // id는 자동 생성이어서 안 받아 와도 됨
    @Builder
    public CommentLike(Comment comment, Account account) {
        this.comment = comment;
        this.account = account;
    }
}