package com.huiwings.blog.mapper;

import com.huiwings.blog.entity.ArticleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:45
 */
public interface ArticleMapper {

    @Select("select * from article where type_code=#{typeCode} and dr =1")
    @ResultMap("ArticleResultMap")
    List<ArticleEntity> findGroupByType(@Param("typeCode") int typeCode);

    @Select("select * from article where aid=#{aid} and dr=1")
    @Results({
            @Result(property = "id", column = "aid", javaType = Long.class),
            @Result(property = "title", column = "title", javaType = String.class),
            @Result(property = "content", column = "content"),
            @Result(property = "author", column = "author"),
            @Result(property = "typeCode", column = "type_code"),
            @Result(property = "ct", column = "create_time"),
            @Result(property = "ts", column = "ts"),
            @Result(property = "likes", column = "c_like"),
    })
    ArticleEntity findById(@Param("aid") Long id);
}
