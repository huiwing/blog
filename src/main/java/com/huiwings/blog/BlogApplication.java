package com.huiwings.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huiwings.blog.mybatis.mapper")
public class BlogApplication {

    /* @Override
     protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
         return applicationBuilder.sources(BlogApplication.class);
     }
 */
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
