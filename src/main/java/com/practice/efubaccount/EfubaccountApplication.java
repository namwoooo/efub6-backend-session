package com.practice.efubaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EfubaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfubaccountApplication.class, args);
	}

}
