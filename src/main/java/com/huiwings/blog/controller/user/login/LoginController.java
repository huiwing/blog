package com.huiwings.blog.controller.user.login;

import com.huiwings.blog.controller.base.BaseController;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.entity.UserEntity;
import com.huiwings.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:15
 */
@RestController
public class LoginController extends BaseController {
    @Autowired
    private UserService service;

    @PostMapping("login")
    public ResponseEntity login(String username, String password) {
        Long loginResult = service.login(username, password);
        if (loginResult != 0) {
            return returnOk(loginResult, "登录成功");
        } else {
            return returnError("登录失败");
        }
    }

    @GetMapping("users")
    public ResponseEntity getAllUsers() {
        List<UserEntity> listResult = service.findAll();
        if (listResult != null) {
            return returnOk(listResult, "查询成功");
        } else {
            return returnError("查询失败");
        }
    }
}
