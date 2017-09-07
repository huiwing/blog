package com.huiwings.blog.controller.article;

import com.huiwings.blog.controller.base.BaseController;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * huiwings@163.com
 * Create By 2017/9/7 17:20
 */
@RestController
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService service;

    @GetMapping("article/{page}/{count}")
    public ResponseEntity findByUserOrType(@PathVariable("page") int page, @PathVariable("count") int count,
                                           @RequestParam(value = "type", required = false) int typeCode,
                                           @RequestParam(value = "user", required = false) String username) {
        return returnOk(service.findGroupByTypeAndUser(typeCode, username), "查询成功");

    }
}
