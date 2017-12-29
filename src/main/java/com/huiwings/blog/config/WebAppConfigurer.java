package com.huiwings.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * huiwings@163.com
 * Create By 2017/12/25 11:08
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**");//需要拦截的路径
        //.excludePathPatterns("/users/login");//略过的路径
        super.addInterceptors(registry);
    }*/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
        super.addCorsMappings(registry);
    }
}
