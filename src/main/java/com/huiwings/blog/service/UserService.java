package com.huiwings.blog.service;

import com.huiwings.blog.entity.UserEntity;
import com.huiwings.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 9:49
 */
@Service
public class UserService implements UserMapper {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public UserEntity findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public Long login(String username, String password) {
        return userMapper.login(username, password);
    }
}
