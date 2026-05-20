package com.practice.efubaccount.follow.domain;

import com.practice.efubaccount.account.domain.Account;
import com.practice.efubaccount.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow extends BaseEntity {

    @Id
    @Column(name = "follow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Account <-> Account (다대다 관계) -> 지양
    // Account <-> Follow <-> Account

    // 팔로우 하는 사람
    @ManyToOne(fetch = FetchType.LAZY)  // 내가 여러 명을 팔로우 할 수 있음
    @JoinColumn(name = "follower_id", nullable = false, updatable = false)
    private Account follower;

    // 팔로우 당하는 사람
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id", nullable = false, updatable = false)
    private Account followee;

    @Builder
    public Follow(Account follower, Account followee) {
        this.follower = follower;
        this.followee = followee;
    }
}
