package com.github.paicoding.forum.core.feign;

import com.github.paicoding.forum.core.context.ReqInfoContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class FeignConfig {


    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("user-id", String.valueOf(Optional.ofNullable(ReqInfoContext.getReqInfo().getUserId()).orElse(0L)));
            }
        };
    }

}
