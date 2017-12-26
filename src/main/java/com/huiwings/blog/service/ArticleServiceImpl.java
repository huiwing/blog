package com.huiwings.blog.service;

import com.huiwings.blog.entity.ArticleBLOBsEntity;
import com.huiwings.blog.entity.ArticleViewEntity;
import com.huiwings.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * huiwings@163.com
 * Create By 2017/12/26 15:36
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper mapper;

    @Override
    public ArticleViewEntity selectById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<ArticleViewEntity> selectByType(int type) {
        return mapper.selectByType(type);
    }

    @Override
    public List<ArticleViewEntity> selectByUid(int uid) {
        return mapper.selectByUid(uid);
    }

    @Override
    public List<ArticleViewEntity> selectByUidType(Map<String, Integer> param) {
        return mapper.selectByUidType(param);
    }

    @Override
    public List<ArticleViewEntity> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Long deleteById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public Long deleteByType(int type) {
        return mapper.deleteByType(type);
    }

    @Override
    public Long deleteByUid(int uid) {
        return mapper.deleteByUid(uid);
    }

    @Override
    public Long deleteByUidType(Map<String, Integer> param) {
        return mapper.deleteByUidType(param);
    }

    @Override
    public Long insertSelective(ArticleBLOBsEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public Long updateById(ArticleBLOBsEntity entity) {
        return mapper.updateById(entity);
    }
}
