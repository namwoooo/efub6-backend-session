package com.practice.efubaccount.comment.domain;

import com.practice.efubaccount.account.domain.Account;
import com.practice.efubaccount.global.domain.BaseEntity;
import com.practice.efubaccount.post.domain.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id   // 자동으로 증가하도록 설정
    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=1000)  // DB 제한 1000
    private String content;

    // 연관관계
    // 댓글 - 댓글 작성자
    @ManyToOne(fetch = FetchType.LAZY)  // 지연 로딩 -> 필요한 정보만 가져와 성능 높이도록
    @JoinColumn(name = "account_id", updatable = false)
    private Account writer;  // 댓글 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", updatable = false)
    private Post post;  // 게시글과 댓글 연결


    @Builder
    public Comment(String content, Account writer, Post post) {
        this.content = content;
        this.writer = writer;
        this.post = post;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}