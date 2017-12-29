package com.huiwings.blog.service;

import com.huiwings.blog.entity.CommentEntity;
import com.huiwings.blog.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/12/27 9:55
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper mapper;

    @Override
    public CommentEntity findById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<CommentEntity> findByAid(int aid) {
        return mapper.selectByAid(aid);
    }

    @Override
    public Long delById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public Long delByAid(int aid) {
        return mapper.deleteByAid(aid);
    }

    @Override
    public Long add(CommentEntity entity) {
        return mapper.insertSelective(entity);
    }
}
