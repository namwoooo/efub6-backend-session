package com.practice.efubaccount.service;

import com.practice.efubaccount.dto.response.AccountResponseDto;
import com.practice.efubaccount.dto.response.CreateAccountResponseDto;
import com.practice.efubaccount.dto.request.BioUpdateRequestDto;
import com.practice.efubaccount.dto.request.CreateAccountRequestDto;
import com.practice.efubaccount.domain.Account;
import com.practice.efubaccount.domain.AccountStatus;
import com.practice.efubaccount.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountsService {

    private final AccountRepository accountRepository;

    // 회원 단건 조회
    public AccountResponseDto getAccount(Long accountId) {

    }

    // 회원 생성
    @Transactional
    public CreateAccountResponseDto createAccount(CreateAccountRequestDto requestDto) {

    }

    // 프로필(자기소개) 수정
    @Transactional
    public AccountResponseDto updateAccount(Long accountId, BioUpdateRequestDto requestDto) {

    }

    // 회원 논리적 삭제 (status 변경)
    @Transactional
    public void deleteAccount(Long accountId) {

    }

    // 회원 물리적 삭제
    @Transactional
    public void physicalDeleteAccount(Long accountId) {

    }
}