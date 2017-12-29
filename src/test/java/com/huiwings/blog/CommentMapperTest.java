package com.huiwings.blog;

import com.alibaba.fastjson.JSON;
import com.huiwings.blog.entity.CommentEntity;
import com.huiwings.blog.service.CommentServiceImpl;
import com.huiwings.blog.utils.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * huiwings@163.com
 * Create By 2017/12/27 9:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    CommentServiceImpl service;

    @Test
    public void testFind() throws Exception {
        System.out.println(JSON.toJSONString(service.findById(1)));
    }

    @Test
    public void testDel() throws Exception {
        System.out.println(JSON.toJSONString(service.delById(1)));
    }

    @Test
    public void testAdd() throws Exception {
        CommentEntity entity = new CommentEntity();
        entity.setAid(3);
        entity.setContent("真的大神啊");
        entity.setCreateTime(TimeUtil.getDateMillis());
        entity.setUsername("huiwings");
        System.out.println(JSON.toJSONString(service.add(entity)));
    }

}
