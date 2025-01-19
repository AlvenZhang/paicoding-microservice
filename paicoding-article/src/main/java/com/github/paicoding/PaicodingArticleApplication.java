package com.github.paicoding;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaicodingArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaicodingArticleApplication.class, args);
    }
}
