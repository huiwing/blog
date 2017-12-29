package com.huiwings.blog;

import com.alibaba.fastjson.JSON;
import com.huiwings.blog.entity.ArticleBLOBsEntity;
import com.huiwings.blog.service.ArticleServiceImpl;
import com.huiwings.blog.utils.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * huiwings@163.com
 * Create By 2017/9/7 14:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {
    @Autowired
    private ArticleServiceImpl service;

    @Test
    public void testFind() throws Exception {
        //List<ArticleViewEntity> entity = service.selectAll();
        System.out.println(JSON.toJSONString(service.selectAll()));
    }

    @Test
    public void testAdd() throws Exception {
        ArticleBLOBsEntity entity = new ArticleBLOBsEntity();
        entity.setTitle("真的震惊");
        entity.setContent("这一天，全世界都真的震惊了");
        entity.setCreateTime(TimeUtil.getDateMillis());
        entity.setTs(TimeUtil.getDateMillis());
        entity.setUid(5);
        System.out.println(service.insertSelective(entity));
    }

    @Test
    public void testDel() throws Exception {
        System.out.println(service.deleteByUid(5));
    }

    @Test
    public void testUpdate() throws Exception {
        ArticleBLOBsEntity entity = new ArticleBLOBsEntity();
        entity.setAid(2);
        entity.setTitle("帅哥");
        entity.setContent("真正的帅哥，都是平头");
        System.out.println(service.updateById(entity));
    }
}
