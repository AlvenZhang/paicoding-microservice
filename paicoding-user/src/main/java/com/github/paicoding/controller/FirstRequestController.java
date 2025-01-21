package com.github.paicoding.controller;


import com.github.paicoding.client.ArticleClient;
import com.github.paicoding.client.GatewayClient;
import com.github.paicoding.client.OriginClient;
import com.github.paicoding.forum.api.model.vo.user.dto.UserStatisticInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class FirstRequestController {

    @Autowired
    private OriginClient articleClient;

    @Autowired
    private GatewayClient gatewayClient;

    @Autowired
    private ArticleClient articleClientReal;

    @RequestMapping("/interceptor/test")
    public String interceptorTest(){
        return articleClientReal.test1();
    }

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello world";
    }

    @RequestMapping("/rpcRest")
    public UserStatisticInfoDTO rpcTest(){
        String s = articleClient.testFeign();
        UserStatisticInfoDTO userStatisticInfoDTO = articleClient.queryUserStatisticInfo(1L);
        return userStatisticInfoDTO;
    }

    @RequestMapping("/testParam")
    public HashMap<String, Integer> testParam(Integer integer){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(String.valueOf(integer), integer);
        return gatewayClient.testParam(map);
    }
}
