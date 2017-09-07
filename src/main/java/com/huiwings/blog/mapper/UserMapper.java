package com.huiwings.blog.mapper;

import com.huiwings.blog.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 9:22
 */
public interface UserMapper {
    @Select("select * from user where dr = 1")
    @ResultMap("UserResultMap")
    List<UserEntity> findAll();

    @Select("select * from user where id=#{id} and dr = 1")
    @ResultMap("UserResultMap")
    UserEntity findById(@Param("id") Long id);

    @Select("select * from user where username=#{username} and dr=1")
    @ResultMap("UserResultMap")
    UserEntity findByUserName(@Param("username") String username);

    @Select("select u.id from user u where u.username = #{username} and u.password = #{password} and dr=1")
    @Result(property = "id", column = "id")
    Long login(@Param("username") String username, @Param("password") String password);

}
