package com.wzportal.app.controller;

import com.wzportal.app.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private MailService mailService;

    @GetMapping("/hello")
    public String sendMail(String name) throws MessagingException {
        Map<String, Object> data = new HashMap<>(1);
        data.put("name", name);
        mailService.sendMail(data);
        return "success";
    }
}
