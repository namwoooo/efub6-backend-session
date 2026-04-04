//package com.practice.efubaccount.post.domain;
//
//import com.practice.efubaccount.account.domain.Account;
//import com.practice.efubaccount.global.domain.BaseEntity;
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class Post{
//
//    @Builder
//    public Post(String title, Account writer, String content) {
//        this.title = title;
//        this.writer = writer;
//        this.content = content;
//        this.viewCount = 0L;
//    }
//
//    public void changeContent(String newContent) {
//        this.content = newContent;
//    }
//}