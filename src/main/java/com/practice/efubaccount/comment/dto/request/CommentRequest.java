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
    private String comment;

    // 연관관계를 설정했기 때문에 account와 post에서도 가져와서 사용 가능
    public Comment toEntity(Account account, Post post) {
        // dto를 실제 db에 저장할 entity로 만드는 method
        return Comment.builder()
                .content(comment)
                .writer(account)
                .post(post)
                .build();
    }


}