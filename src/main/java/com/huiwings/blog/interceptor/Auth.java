package com.huiwings.blog.interceptor;

import java.lang.annotation.*;

/**
 * 在类或方法上添加@Auth就验证登录
 * huiwings@163.com
 * Create By 2017/12/25 10:46
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
}
