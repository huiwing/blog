package com.huiwings.blog.controller.user.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * huiwings@163.com
 * Create By 2017/9/13 17:01
 */
@Controller
public class TestLoginController {
    @RequestMapping(value = "/lo", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
