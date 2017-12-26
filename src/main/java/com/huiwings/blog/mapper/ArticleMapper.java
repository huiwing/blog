package com.huiwings.blog.mapper;

import com.huiwings.blog.entity.ArticleViewEntity;
import com.huiwings.blog.entity.ArticleBLOBsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:45
 */
@Mapper
public interface ArticleMapper {

    ArticleViewEntity selectById(int id);

    List<ArticleViewEntity> selectByType(int type);

    List<ArticleViewEntity> selectByUid(int uid);

    List<ArticleViewEntity> selectByUidType(Map<String, Integer> param);

    List<ArticleViewEntity> selectAll();

    Long deleteById(int id);

    Long deleteByType(int type);

    Long deleteByUid(int uid);

    Long deleteByUidType(Map<String, Integer> param);

    Long insertSelective(ArticleBLOBsEntity entity);

    Long updateById(ArticleBLOBsEntity entity);

}
