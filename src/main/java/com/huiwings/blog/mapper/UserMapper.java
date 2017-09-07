package com.huiwings.blog.mapper;

import com.huiwings.blog.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 9:22
 */
public interface UserMapper {
    @Select("select * from user where dr = 1")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age")
    })
    List<UserEntity> findAll();

    @Select("select * from user where id=#{id} and dr = 1")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age")
    })
    UserEntity findById(@Param("id") Long id);

    @Select("select * from user where username=#{username} and dr=1")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age")
    })
    UserEntity findByUserName(@Param("username") String username);

    @Select("select u.id from user u where u.username = #{username} and u.password = #{password} and dr=1")
    @Result(property = "id", column = "id")
    Long login(@Param("username") String username, @Param("password") String password);

}
