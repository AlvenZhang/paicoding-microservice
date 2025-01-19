package com.github.paicoding.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.paicoding.mapper")
public class MyBatisPlusConfig {

}
