package com.huiwings.blog.mapper;

import com.huiwings.blog.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 9:22
 */
@Mapper
public interface UserMapper {
    UserEntity selectById(int id);

    List<UserEntity> selectByNickname(String name);

    UserEntity selectByUsername(String name);

    List<UserEntity> selectAll();

    Long deleteByPrimaryKey(int id);

    Long insertSelective(UserEntity entity);

    Long updateByPrimaryKeySelective(UserEntity entity);

}
