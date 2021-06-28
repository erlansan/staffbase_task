package com.example.faq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.faq")
public class FaqApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaqApplication.class, args);
	}

}
