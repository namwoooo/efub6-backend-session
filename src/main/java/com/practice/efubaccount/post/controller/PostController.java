//package com.practice.efubaccount.post.controller;
//
//import com.practice.efubaccount.post.dto.request.PostCreateRequest;
//import com.practice.efubaccount.post.dto.request.PostUpdateRequest;
//import com.practice.efubaccount.post.dto.response.PostListResponse;
//import com.practice.efubaccount.post.dto.response.PostResponse;
//import com.practice.efubaccount.post.service.PostService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//
//@RestController
//@RequestMapping("/posts")
//@RequiredArgsConstructor
//public class PostController {
//    private final PostService postService;
//
//    // 게시물 생성
//    @PostMapping
//    public ResponseEntity<Void> createPost() {
//    }
//
//    // 게시물 전체 조회
//    @GetMapping
//    public ResponseEntity<PostListResponse> getAllPosts(){
//    }
//
//    // 게시물 1개 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<PostResponse> getPost(
//    }
//
//    // 게시글 수정
//    @PatchMapping("/{id}")
//    public ResponseEntity<Void> updatePostContent(
//    }
//
//    // 게시글 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePost(
//    }
//}
