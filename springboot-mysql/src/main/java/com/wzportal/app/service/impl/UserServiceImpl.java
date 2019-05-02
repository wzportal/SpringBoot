package com.wzportal.app.service.impl;

import com.wzportal.app.entity.UserEntity;
import com.wzportal.app.mapper.UserEntityMapper;
import com.wzportal.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityMapper userEntityMapper;

    public int addUser(UserEntity userEntity) {
        return userEntityMapper.insertSelective(userEntity);
    }
}
