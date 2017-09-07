package com.huiwings.blog;

import com.huiwings.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * huiwings@163.com
 * Create By 2017/9/7 9:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserService service;

    @Test
    public void testFindAll() throws Exception {
        System.out.println(service.findAll());
    }
    @Test
    public void testLogin() throws Exception{
        System.out.println(service.login("huiwings","111111"));
    }
}
