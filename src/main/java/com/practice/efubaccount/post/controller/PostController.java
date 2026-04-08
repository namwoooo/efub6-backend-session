package com.practice.efubaccount.post.controller;

import com.practice.efubaccount.post.dto.request.PostCreateRequest;
import com.practice.efubaccount.post.dto.request.PostUpdateRequest;
import com.practice.efubaccount.post.dto.response.PostListResponse;
import com.practice.efubaccount.post.dto.response.PostResponse;
import com.practice.efubaccount.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시물 생성
    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostCreateRequest request) {  // 검증하기 위해 @Valid 추가
        Long id = postService.createPost(request);
        return ResponseEntity.created(URI.create("/posts/"+id)).build();  // Alt + Enter 누르면 import 자동으로 됨
    }

    // 게시물 전체 조회
    @GetMapping
    public ResponseEntity<PostListResponse> getAllPosts(){
        PostListResponse response = postService.getAllPosts();
        return ResponseEntity.ok(response);
    }

    // 게시물 1개 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("id") Long postId) {
        PostResponse response = postService.getPost(postId);
        return ResponseEntity.ok(response);
    }

    // 게시글 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePostContent(@PathVariable("id") Long postId,
                                                  @RequestHeader("Auth-Id") Long accountId,
                                                  @Valid @RequestBody PostUpdateRequest request) {
        postService.updatePostContent(postId, accountId, request);
        return ResponseEntity.noContent().build();   // 204 No Content 반환
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long postId,
                                           @RequestHeader("Auth-Id") Long accountId){
        postService.deletePost(postId, accountId);
        return ResponseEntity.noContent().build();
    }
}
