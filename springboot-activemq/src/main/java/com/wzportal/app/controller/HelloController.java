package com.wzportal.app.controller;

import com.wzportal.app.jms.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private JmsService jmsService;

    @GetMapping("/hello")
    public String hello(String msg) {
        jmsService.sendMsg(msg);
        return "success";
    }
}
