package com.github.paicoding;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping("/request1")
    public HashMap<String, Integer> test1(@RequestBody HashMap<String, Integer> map){
        System.out.println(map);
        map.put("test", 1);
        return map;
    }
}
