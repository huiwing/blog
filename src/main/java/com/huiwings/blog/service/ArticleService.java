package com.huiwings.blog.service;

import com.huiwings.blog.entity.ArticleBLOBsEntity;
import com.huiwings.blog.entity.ArticleViewEntity;

import java.util.List;
import java.util.Map;

/**
 * huiwings@163.com
 * Create By 2017/9/7 14:38
 */
public interface ArticleService {

    /**
     * 通过ID
     *
     * @param id
     * @return
     */
    ArticleViewEntity selectById(int id);

    /**
     * 通过类型
     *
     * @param type
     * @return
     */
    List<ArticleViewEntity> selectByType(int type);

    /**
     * 通过用户id
     *
     * @param uid
     * @return
     */
    List<ArticleViewEntity> selectByUid(int uid);

    /**
     * 通过用户ID+type
     *
     * @param param
     * @return
     */
    List<ArticleViewEntity> selectByUidType(Map<String, Integer> param);

    /**
     * 所有数据
     *
     * @return
     */
    List<ArticleViewEntity> selectAll();

    Long deleteById(int id);

    Long deleteByType(int type);

    Long deleteByUid(int uid);

    Long deleteByUidType(Map<String, Integer> param);

    /**
     * 插入
     *
     * @param entity
     * @return
     */
    Long insertSelective(ArticleBLOBsEntity entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    Long updateById(ArticleBLOBsEntity entity);


}
