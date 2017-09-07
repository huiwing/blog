package com.huiwings.blog.mapper;

import com.huiwings.blog.entity.ArticleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:45
 */
public interface ArticleMapper {

    @Select("select * from t_article where type_code=#{typeCode} and dr =1")
    @ResultMap("ArticleResultMap")
    List<ArticleEntity> findGroupByType(int typeCode);

    @Select("select * from t_article where author=#{user} and dr =1")
    @ResultMap("ArticleResultMap")
    List<ArticleEntity> findGroupByUser(String user);

    @Select("select * from t_article where type_code=#{typeCode} and author=#{user} and dr=1")
    List<ArticleEntity> findGroupByTypeAndUser(@Param("typeCode") int typeCode, @Param("user") String user);

    @Select("select * from t_article where aid=#{aid} and dr=1")
    @ResultMap("ArticleResultMap")
    ArticleEntity findById(@Param("aid") Long id);

}
