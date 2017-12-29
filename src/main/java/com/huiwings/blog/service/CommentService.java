package com.huiwings.blog.service;

import com.huiwings.blog.entity.CommentEntity;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/12/27 9:55
 */
public interface CommentService {
    CommentEntity findById(int id);

    List<CommentEntity> findByAid(int aid);

    Long delById(int id);

    Long delByAid(int aid);

    Long add(CommentEntity entity);
}
