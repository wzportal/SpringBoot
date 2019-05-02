package com.wzportal.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> test(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>(2);
        String sid = request.getSession().getId();
        result.put("sessionId", sid);
        return result;
    }
}
