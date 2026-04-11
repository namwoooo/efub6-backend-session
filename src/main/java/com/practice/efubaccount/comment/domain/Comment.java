package com.practice.efubaccount.comment.domain;

import com.practice.efubaccount.account.domain.Account; // 여기 주석
import com.practice.efubaccount.global.domain.BaseEntity; // 여기 주석
import com.practice.efubaccount.post.domain.Post; // 여기 주석
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter // 필드 값을 조회하기 위해서 getter 메서드 자동 생성하는 어노테이션
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자를 만들되, 외부에서 무분별하게 생성하지 못하도록 protected로 제한
public class Comment extends BaseEntity { // 공통 필드(생성 시간, 수정 시간)를 상속

    @Id // 기본키로 사용하겠다는 의미
    @Column(name="comment_id") // DB 칼럼명 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 값을 DB가 자동으로 증가시켜 생성하도록 설정
    private Long id;

    @Column(length=1000) // 길이 제한
    private String content; // 댓글 내용 저장 

    // 연관관계
    @ManyToOne(fetch = FetchType.LAZY) // 댓글 많고 사람 한 명, 지연 로딩 설정
    // 댓글만 조회할 때는 작성자 정보까지 바로 가져오지 않고, 필요할 때만 가져와서 성능을 고려한 설정
    @JoinColumn(name="account_id",updatable = false) // 외래키 컬럼명을 account_id로 지정해서 댓글 테이블이 작성자 정보를 참조
    // 댓글 작성자는 한 번 정해지면 수정되지 않도록 설정
    private Account writer;

    @ManyToOne(fetch = FetchType.LAZY) // 하나의 게시글에 여러 개 댓글
    @JoinColumn(name="post_id", updatable = false) // 댓글이 어느 게시글에 속하는지는 생성 이후 수정되지 않도록 설정
    private Post post;

    @Builder // 빌더 패턴 사용 -> 생성자 방식보다 가독성이 좋고, 어떤 값이 들어가는지 명확하게 객체를 생성해줘서 좋음!
    public Comment(String content, Account writer, Post post) {
        this.content = content;
        this.writer = writer;
        this.post = post;
    }
}