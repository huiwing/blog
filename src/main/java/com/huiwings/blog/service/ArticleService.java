package com.huiwings.blog.service;

import com.huiwings.blog.entity.ArticleEntity;
import com.huiwings.blog.mapper.ArticleMapper;
import com.huiwings.blog.utils.TextUtils;
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
    public List<ArticleEntity> findGroupByUser(String user) {
        return mapper.findGroupByUser(user);
    }

    @Override
    public List<ArticleEntity> findGroupByTypeAndUser(int typeCode, String user) {
        if (typeCode <= 0) {
            if (!TextUtils.isEmpty(user)) {//只有User
                return mapper.findGroupByUser(user);
            } else {
                return mapper.findGroupByType(typeCode);
            }
        } else {
            if (!TextUtils.isEmpty(user)) {//两个参数都有
                return mapper.findGroupByTypeAndUser(typeCode, user);
            }
            return mapper.findGroupByType(typeCode);//只有Type
        }
    }

    @Override
    public ArticleEntity findById(Long id) {
        return mapper.findById(id);
    }
}
