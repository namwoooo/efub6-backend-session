package com.practice.efubaccount.post.domain;

import com.practice.efubaccount.account.domain.Account;
import com.practice.efubaccount.comment.domain.Comment;

import com.practice.efubaccount.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account writer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long viewCount;

    // 연관관계의 Owner 설정
    // post 하나 당 여러 개의 comment -> comment가 주인
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)  // cascade: post가 삭제되면 모든 댓글이 함께 삭제
    private List<Comment> commentList = new ArrayList<>();


    @Builder
    public Post(String title, Account writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.viewCount = 0L;
    }

    public void changeContent(String newContent) {
        this.content = newContent;
    }
}