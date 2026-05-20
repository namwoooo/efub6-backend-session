package com.practice.efubaccount.follow.repository;

import com.practice.efubaccount.account.domain.Account;
import com.practice.efubaccount.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    // 이미 팔로우 해둔 상태인지 확인
    boolean existsByFollowerAndFollowee(Account requester, Account target);

    Optional<Follow> findByFollowerAndFollowee(Account requester, Account target);

    // followee가 일치하는 계정을 모두 가져오는 메소드
    // fetchJoin을 사용하여 1 + N 문제 방지
    @Query("SELECT f FROM Follow f JOIN FETCH f.follower WHERE f.followee = :requester")
    List<Follow> findAllByFollowee(@Param("requester") Account followee);

    // follower가 팔로웃하고 있는 모든 계정을 가져오는 메소드
    // fetchJoin을 사용하여 1 + N 문제 방지
    @Query("SELECT f FROM Follow f JOIN FETCH f.followee WHERE f.follower = :requester")
    List<Follow> findAllByFollower(@Param("requester") Account follower);
}
