package com.github.paicoding.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient("gateway")
public interface GatewayClient {

    @RequestMapping(value = "/test/request1", method = RequestMethod.POST)
    HashMap<String, Integer> testParam(@RequestBody HashMap<String, Integer> map);
}
