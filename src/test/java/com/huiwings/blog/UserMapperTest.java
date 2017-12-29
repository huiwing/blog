package com.huiwings.blog;

import com.alibaba.fastjson.JSON;
import com.huiwings.blog.service.UserServiceImpl;
import com.huiwings.blog.entity.UserEntity;
import com.huiwings.blog.utils.TimeUtil;
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
    private UserServiceImpl service;

    @Test
    public void testFindAll() throws Exception {
        //System.out.println(service.findAll());
    }

    @Test
    public void testLogin() throws Exception {
        System.out.println("----------------->" + JSON.toJSONString(service.selectAll()));
    }

    @Test
    public void testInsert() throws Exception {
        UserEntity entity = new UserEntity();
        entity.setUsername("yuan");
        entity.setAge(23);
        entity.setEmail("yuan@email.com");
        entity.setNickname("袁康");
        entity.setPassword("111111");
        entity.setCreateTime(TimeUtil.getDateMillis());
        entity.setTs(TimeUtil.getDateMillis());
        entity.setLv(1);
        Long result = service.insertSelective(entity);
        System.out.println("result--------->" + result);
    }

    @Test
    public void testDel() throws Exception {
        System.out.println(service.deleteByPrimaryKey(4));
    }

    @Test
    public void update() throws Exception {
        UserEntity entity = new UserEntity();
        entity.setId(4);
        entity.setPassword("333333");
        System.out.println(service.updateByPrimaryKeySelective(entity));
    }
}
