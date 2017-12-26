package com.huiwings.blog.config;

import com.huiwings.blog.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * huiwings@163.com
 * Create By 2017/12/25 11:08
 */
//@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//需要拦截的路径
                .excludePathPatterns("/users/login");//略过的路径
        super.addInterceptors(registry);
    }
}
