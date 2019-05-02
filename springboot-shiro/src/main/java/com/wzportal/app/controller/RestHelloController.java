package com.wzportal.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @GetMapping("/hello")
    public String hello() {
        return "success";
    }
}
