package com.huiwings.blog.controller;

import com.github.pagehelper.PageHelper;
import com.huiwings.blog.Constants;
import com.huiwings.blog.controller.base.BaseController;
import com.huiwings.blog.entity.ArticleBLOBsEntity;
import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.entity.UserEntity;
import com.huiwings.blog.http.ResponseCode;
import com.huiwings.blog.service.ArticleServiceImpl;
import com.huiwings.blog.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;


/**
 * huiwings@163.com
 * Create By 2017/9/7 17:20
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleServiceImpl service;

    @GetMapping("{aid}")
    public ResponseEntity findById(@PathVariable("aid") int aid) {
        ArticleBLOBsEntity entity = service.selectById(aid);
        if (entity != null) {
            return returnOk(entity, "查询成功");
        } else {
            return returnError("查询失败");
        }
    }

    @GetMapping("list/{page}/{count}")
    public ResponseEntity findByKey(
            @PathVariable("page") int page, @PathVariable("count") int count,
            @RequestParam(value = "type", required = false, defaultValue = "0") int typeCode,
            @RequestParam(value = "uid", required = false, defaultValue = "0") int uid) {
        List<ArticleBLOBsEntity> entities;
        PageHelper.startPage(page, count);
        return returnOk(service.selectByType(typeCode), Constants.QUERY_OK);
    }

    @PostMapping("add")
    public ResponseEntity add(HttpSession session, @RequestBody ArticleBLOBsEntity entity) {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        entity.setUid(userEntity.getId());
        entity.setCreateTime(TimeUtil.getDateMillis());
        entity.setTs(TimeUtil.getDateMillis());
        Long result = service.insertSelective(entity);
        return result <= 0 ? returnError("插入失败") : returnOk("插入成功");
    }

    @PostMapping("update")
    public ResponseEntity update(HttpSession session, @RequestBody ArticleBLOBsEntity entity) {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        long result = 0;
        if (Objects.equals(userEntity.getId(), entity.getUid())) {
            result = service.updateById(entity);
        }
        return result <= 0 ? returnError("更新失败") : returnOk("更新成功");
    }

    @GetMapping("del/{aid}")
    public ResponseEntity del(HttpSession session,
                              @PathVariable(value = "aid") int aid) {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        long result;
        if (Objects.equals(service.selectById(aid).getUid(), userEntity.getId()) || userEntity.getLv() == 3) {
            result = service.deleteById(aid);
            return result <= 0 ? returnError("操作失败") : returnOk("操作成功");
        } else {
            return returnResult(ResponseCode.NO_PERMISSION);
        }
    }

}
