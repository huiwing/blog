package com.huiwings.blog;


import com.alibaba.fastjson.JSON;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.utils.TextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.PrintWriter;


/**
 * 登录认证拦截器
 * huiwings@163.com
 * Create By 2017/12/25 10:40
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        if (!TextUtils.isEmpty((String) session.getAttribute("user"))) {//判断session是否存在
            return true;
        } else {
            PrintWriter printWriter = response.getWriter();
            response.setHeader("Content-Type", "application/json");
            printWriter.write(JSON.toJSONString(new ResponseEntity(202, "未登录")));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
    }
}
