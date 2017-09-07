package com.huiwings.blog.controller.article;

import com.huiwings.blog.entity.ArticleEntity;
import com.huiwings.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 14:38
 */
@Service
public class ArticleService implements ArticleMapper {
    @Autowired
    ArticleMapper mapper;

    @Override
    public List<ArticleEntity> findGroupByType(int typeCode) {
        return mapper.findGroupByType(typeCode);
    }

    @Override
    public ArticleEntity findById(Long id) {
        return mapper.findById(id);
    }
}
