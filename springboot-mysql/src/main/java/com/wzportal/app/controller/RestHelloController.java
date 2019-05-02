package com.wzportal.app.controller;

import com.wzportal.app.entity.UserEntity;
import com.wzportal.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class RestHelloController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String addUser(String name) {
        UserEntity user = new UserEntity();
        user.setId(UUID.randomUUID().toString());// 主键 UUID
        user.setName(name);
        user.setAge(18);
        user.setBorn(new Date());
        userService.addUser(user);
        return "success";
    }
}
