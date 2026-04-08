package com.practice.efubaccount.post.service;

import com.practice.efubaccount.account.domain.Account;
import com.practice.efubaccount.account.service.AccountsService;
import com.practice.efubaccount.global.exception.CustomException;
import com.practice.efubaccount.global.exception.ErrorCode;
import com.practice.efubaccount.post.domain.Post;
import com.practice.efubaccount.post.dto.request.PostCreateRequest;
import com.practice.efubaccount.post.dto.request.PostUpdateRequest;
import com.practice.efubaccount.post.dto.response.PostListResponse;
import com.practice.efubaccount.post.dto.response.PostResponse;
import com.practice.efubaccount.post.dto.summary.PostSummary;
import com.practice.efubaccount.post.repository.PostRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final AccountsService accountsService;
    private final PostRepository postRepository;

    @Transactional
    public Long createPost(PostCreateRequest request) {
        Account writerAccount = accountsService.findByAccountId(request.getAccountId());

        Post newPost = request.toEntity(writerAccount);
        postRepository.save(newPost);
        return newPost.getId();
    }

    @Transactional(readOnly = true)
    public PostListResponse getAllPosts() {
        List<PostSummary> postSummaries = postRepository.findAllByOrderByCreatedAtDesc()
                .stream()  // stream으로 list를 하나하나 쪼개줌
                .map(PostSummary::from)  // post가 인자로 들어가서 PostSummary가 된다
                .toList();
        return new PostListResponse(postSummaries, postRepository.count());
    }

    @Transactional   // 조회수 변경이 되기 때문에 readOnly = false
    public PostResponse getPost(Long postId) {
        // 조회수 증가
        postRepository.increaseViewCount(postId);   // domain에 작성해놓은 JPQL -> 단순한 작업은 이게 성능이 더 좋음

        Post post = findByPostId(postId);
        return PostResponse.from(post);  // 원하는 post response로 매핑돼서 반환됨
    }

    @Transactional
    public void updatePostContent(Long postId, Long accountId, @Valid PostUpdateRequest request) {
        Post post = findByPostId(postId);  // Ctrl + Alt + V 변수(?)명 생성
        Account account = accountsService.findByAccountId(accountId);

        // 게시물 작성자 = 계정 사용자 검증
        authorizePostWriter(post, account);
        post.changeContent(request.content());
    }

    @Transactional
    public void deletePost(Long postId, Long accountId) {
        Post post = findByPostId(postId);
        Account account = accountsService.findByAccountId(accountId);

        authorizePostWriter(post, account);
        postRepository.delete(post);
    }

    public Post findByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
    }

    private void authorizePostWriter(Post post, Account account) {  // 게시물 작성자와 계정이 동일한지 확인
        if (!post.getWriter().equals(account)) {
            throw new CustomException(ErrorCode.POST_ACCOUNT_MISMATCH);
        }
    }
}
