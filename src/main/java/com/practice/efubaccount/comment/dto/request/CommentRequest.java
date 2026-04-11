package com.practice.efubaccount.comment.dto.request;

import com.practice.efubaccount.account.domain.Account;
import com.practice.efubaccount.comment.domain.Comment;
import com.practice.efubaccount.post.domain.Post;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRequest {
    // 댓글 작성자 ID, 댓글 내용 전달받기 위한 필드 정의
    private Long accountId;
    private String content;

    // DRO 한 번 더 설명 : 클라이언트의 데이터 -> 실제 DB에 저장할 엔티티로 변환하기 위해 사용
    public Comment toEntity(Account account, Post post) {
        return Comment.builder()
                .content(content)
                .writer(account)
                .post(post)
                .build();
    }

}