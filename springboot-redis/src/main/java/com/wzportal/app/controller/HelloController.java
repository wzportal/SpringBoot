package com.wzportal.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    public String redis(String msg) {
        if (StringUtils.isEmpty(msg)) {
            return "failure";
        }
        stringRedisTemplate.opsForValue().set("aaa", msg);
        return "success";
    }
}
