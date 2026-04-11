package com.practice.efubaccount.post.controller;

import com.practice.efubaccount.comment.dto.request.CommentRequest;
import com.practice.efubaccount.comment.service.CommentService;
import com.practice.efubaccount.post.dto.response.PostCommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor // 필드를 기반으로 생성자를 자동 생성하고, 의존성을 주입받기 위해 사용 -> 여기서는 CommentService라는 필드 기반!
@RequestMapping("/posts/{postId}/comments") // 기본 URL 설정 -> 명사는 복수형으로~
public class PostCommentController {

    private final CommentService commentService;

    // @ResponseBody 랑 ResponseEntity<> 차이 설명하고 넘어가기
    @PostMapping // 새로운 댓글 생성하는 post 요청 , <Void> : body 선택사항이라는 뜻
    public ResponseEntity<Void> createComment(@PathVariable("postId") Long postId, // url에서 값 가져올거다
                                              @RequestBody CommentRequest request) { // 클라이언트가 보낸 json (댓글 내용, 사용자 아이디)
        Long id = commentService.createComment(postId,request); //ALT + ENTER -> CommentService 에 메소드 생성
        return ResponseEntity.created(URI.create("/posts/"+postId+"/comments/"+id)).build(); // 생성된 uri를 반환할거다 / 바디는 비었음
    }

    @GetMapping
    public ResponseEntity<PostCommentResponse> getComments(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(commentService.getPostCommentList(postId));  //ALT + ENTER -> CommentService 에 메소드 생성
    }
}