package com.github.paicoding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/temptest")
public class TempController {

    @GetMapping("/test1")
    public String test1(HttpServletRequest request){
        return request.getHeader("user-id");
    }

}
