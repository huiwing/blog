package com.huiwings.blog.controller.web;

import com.huiwings.blog.controller.base.BaseController;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.entity.UserEntity;
import com.huiwings.blog.http.ResponseCode;
import com.huiwings.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:15
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService service;

    @PostMapping("login")
    public ResponseEntity login(HttpSession session,
                                @RequestParam("username") String username, @RequestParam("password") String password) {
        //Long loginResult = service.login(username, password);
        UserEntity entity = service.selectByUsername(username);
        long loginResult = 0;
        if (entity.getPassword().equals(password)) {
            loginResult = 1;
        }
        System.out.println("login action");
        if (loginResult != 0) {
            session.setAttribute("user", username);
            Map<String, String> map = new HashMap<>();
            map.put("username", entity.getUsername());
            return returnOk(map, "登录成功");
        } else {
            return returnError("登录失败");
        }
    }

    @GetMapping("list")
    public ResponseEntity getAllUsers() {
        List<UserEntity> listResult = service.selectAll();
        if (listResult != null) {
            return returnOk(listResult, "查询成功");
        } else {
            return returnError();
        }
    }

    @PutMapping("update")
    public ResponseEntity update(HttpSession session, @RequestBody UserEntity user) {
        UserEntity userSession = (UserEntity) session.getAttribute("user");
        user.setId(userSession.getId());
        Long result = service.updateByPrimaryKeySelective(user);
        if (result >= 1) {
            return returnResult(ResponseCode.REQUEST_OK);
        } else {
            return returnError("操作失败");
        }
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity del(HttpSession session, @PathVariable("id") int id) {
        UserEntity userSession = (UserEntity) session.getAttribute("user");
        if (userSession.getLv() < 3) {
            return returnError(ResponseCode.NO_PERMISSION, "没有权限");
        }
        Long result = service.deleteByPrimaryKey(id);
        if (result == 1) {
            return returnOk(ResponseCode.REQUEST_OK, "删除成功");
        }
        return returnError(ResponseCode.REQUEST_ERROR, "删除失败");
    }

}
