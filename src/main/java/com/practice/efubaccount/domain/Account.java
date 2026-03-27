package com.practice.efubaccount.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    // 회원 이메일
    @Column(unique = true)
    private String email;

    // 회원 비밀번호
    @Column(nullable = false)
    private String password;

    // 회원 닉네임
    @Column(nullable = false, updatable = false)
    private String nickname;

    // 회원 자기소개, default 값은 "안녕하세요!"
    @Column
    private String bio="안녕하세요!";

    // 회원 상태
    @Enumerated(EnumType.STRING)
    private AccountStatus status;


}