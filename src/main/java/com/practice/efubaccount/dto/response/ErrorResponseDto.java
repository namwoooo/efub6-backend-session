package com.practice.efubaccount.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseDto {
    // client에게 보여줄 에러 메시지
    private String message;
    private int status;
}