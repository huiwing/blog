package com.huiwings.blog;

import com.huiwings.blog.controller.article.ArticleService;
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
    private ArticleService service;

    @Test
    public void testArticleGroup() throws Exception {
        System.out.println(service.findGroupByType(1));
    }
}
