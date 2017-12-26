package com.huiwings.blog.controller;

import com.huiwings.blog.controller.base.BaseController;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.entity.UserEntity;
import com.huiwings.blog.http.ResponseCode;
import com.huiwings.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:15
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private UserService service;

    @PostMapping("login")
    //@RequestMapping(method = RequestMethod.POST, value = "/login")
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
            return returnOk("登录成功");
        } else {
            return returnError("登录失败");
        }
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/list")
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
        /*UserEntity userSession = (UserEntity) session.getAttribute("user");
        if (!Objects.equals(userSession.getId(), user.getId()) && userSession.getLv() < 3) {
            returnError(ResponseCode.NO_PERMISSION, "没有权限");
        } else {
            user.setId(userSession.getId());
        }
        Long result = service.updateByPrimaryKeySelective(user);
        if (result >= 1) {
            return returnResult(ResponseCode.REQUEST_OK);
        } else {
            return returnError();
        }*/
        return null;
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity del(HttpSession session, @PathVariable("id") int id) {
        UserEntity userSession = (UserEntity) session.getAttribute("user");
        if (userSession.getLv() < 3) {
            return returnError(401, "没有权限");
        }
        Long result = service.deleteByPrimaryKey(id);
        if (result == 1) {
            return returnOk(ResponseCode.REQUEST_OK, "删除成功");
        }
        return returnError(ResponseCode.REQUEST_ERROR, "删除失败");
    }

}
