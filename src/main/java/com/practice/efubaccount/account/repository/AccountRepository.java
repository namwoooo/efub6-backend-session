package com.practice.efubaccount.account.repository;

import com.practice.efubaccount.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // 이메일 중복 검사를 위한 쿼리
    boolean existsByEmail(String email);

    // 회원 Id가 존재하는지 확인
    Optional<Account> findByAccountId(Long accountId);
}
