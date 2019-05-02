package com.wzportal.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用户模块")
public class RestUserController {

    @GetMapping("/users")
    @ApiOperation("查询列表")
    public String users() {
        return "success";
    }

    @PostMapping("/user")
    @ApiOperation("新增")
    public String post() {
        return "success";
    }

    @PutMapping("/user/{id}")
    @ApiOperation("修改")
    public String edit(String id) {
        return "success";
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("删除")
    public String delete(String id) {
        return "success";
    }
}
