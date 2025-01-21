package com.github.paicoding.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("paicoding-article")
public interface ArticleClient {

    @GetMapping("/temptest/test1")
    public String test1();

}
