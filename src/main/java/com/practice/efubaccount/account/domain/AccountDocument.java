package com.practice.efubaccount.account.domain;

import  org.springframework.data.annotation.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "efubblog")
public class AccountDocument {

    // 필드 선언
    @Id
    private String id;
    private String email;
    private String password;
    private String nickname;

    // @Builder 생성자
    @Builder
    public AccountDocument (String id, String email, String password, String nickname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    // 팩토리 메소드
    public static AccountDocument from (Account account) {
        return AccountDocument.builder()
                .id(account.getAccountId().toString())
                .email(account.getEmail())
                .password(account.getPassword())
                .nickname(account.getNickname())
                .build();
    }

    public void updateNickname(String nickname) { this.nickname = nickname; }
}