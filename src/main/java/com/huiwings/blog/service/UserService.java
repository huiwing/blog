package com.huiwings.blog.service;

import com.huiwings.blog.entity.UserEntity;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 9:49
 */
public interface UserService {
    /**
     * 根据ID主键查询
     *
     * @param id
     * @return
     */
    UserEntity selectById(int id);

    /**
     * 根据真实名称查询
     *
     * @param name
     * @return
     */
    List<UserEntity> selectByNickname(String name);

    /**
     * 根据用户名查询
     *
     * @param name
     * @return
     */
    UserEntity selectByUsername(String name);

    /**
     * 查询全部
     *
     * @return
     */
    List<UserEntity> selectAll();

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    Long deleteByPrimaryKey(int id);

    /**
     * 插入
     *
     * @param entity
     * @return
     */
    Long insertSelective(UserEntity entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    Long updateByPrimaryKeySelective(UserEntity entity);
}
