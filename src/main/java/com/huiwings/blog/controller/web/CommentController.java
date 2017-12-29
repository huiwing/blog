package com.huiwings.blog.controller.web;

import com.huiwings.blog.controller.base.BaseController;
import com.huiwings.blog.entity.CommentEntity;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.service.CommentServiceImpl;
import com.huiwings.blog.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * huiwings@163.com
 * Create By 2017/12/27 10:17
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    CommentServiceImpl service;

    @PostMapping("{aid}")
    public ResponseEntity comment(@PathVariable("aid") int aid,
                                  @RequestParam("uname") String uname,
                                  @RequestParam("content") String content) {
        CommentEntity entity = new CommentEntity();
        entity.setAid(aid);
        entity.setUsername(uname);
        entity.setContent(content);
        entity.setCreateTime(TimeUtil.getDateMillis());
        long ret = service.add(entity);
        return ret < 1 ? returnError("评论失败") : returnOk("评论成功");
    }
}
