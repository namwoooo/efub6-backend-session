package com.practice.efubaccount.account.repository;


import com.practice.efubaccount.account.domain.AccountDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository 상속
public interface AccountDocumentRepository extends MongoRepository<AccountDocument, String> {

}