package com.huiwings.blog.controller.article;

import com.github.pagehelper.PageHelper;
import com.huiwings.blog.controller.base.BaseController;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * huiwings@163.com
 * Create By 2017/9/7 17:20
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService service;

    @RequestMapping("")
    public ModelAndView htmlList(){
        return new ModelAndView("");
    }

    @GetMapping("article/{page}/{count}")
    public ResponseEntity findByUserOrType(@PathVariable("page") int page, @PathVariable("count") int count,
                                           @RequestParam(value = "type", required = false, defaultValue = "0") int typeCode,
                                           @RequestParam(value = "user", required = false, defaultValue = "") String username) {
        PageHelper.startPage(page, count);
        return returnOk(service.findGroupByTypeAndUser(typeCode, username), "查询成功");

    }



    @RequestMapping("/add")
    public ModelAndView htmlAdd() {
        return new ModelAndView("articleadd");
    }

}
