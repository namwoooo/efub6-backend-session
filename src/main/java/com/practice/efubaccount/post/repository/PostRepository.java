package com.practice.efubaccount.post.repository;

import com.practice.efubaccount.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 생성한 날짜 정렬 전체 조회  -> JPA가 정해진 이름으로 작성하면 SQL문을 자동으로 생성해준다
    List<Post> findAllByOrderByCreatedAtDesc();

    // 조회수 증가
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p SET p.viewCount = p.viewCount + 1 WHERE p.id = :postId")
    void increaseViewCount(@Param("postId") Long postId);
}
