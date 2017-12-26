package com.huiwings.blog.service;

import com.huiwings.blog.entity.UserEntity;
import com.huiwings.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/12/26 10:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public UserEntity selectById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<UserEntity> selectByNickname(String name) {
        return mapper.selectByNickname(name);
    }

    @Override
    public UserEntity selectByUsername(String name) {
        return mapper.selectByUsername(name);
    }

    @Override
    public List<UserEntity> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Long deleteByPrimaryKey(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insertSelective(UserEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public Long updateByPrimaryKeySelective(UserEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }
}
