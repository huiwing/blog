package com.huiwings.blog.mapper;

import com.huiwings.blog.entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/12/27 9:39
 */
@Mapper
public interface CommentMapper {
    CommentEntity selectById(int id);

    List<CommentEntity> selectByAid(int aid);

    Long deleteById(int id);

    Long deleteByAid(int aid);

    Long insertSelective(CommentEntity entity);
}
