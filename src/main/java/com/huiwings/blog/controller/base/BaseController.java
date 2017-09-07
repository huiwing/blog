package com.huiwings.blog.controller.base;

import com.huiwings.blog.entity.ResponseEntity;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:28
 */
public class BaseController {
    protected ResponseEntity returnOk(Object obj, String msg) {
        return new ResponseEntity(200, obj, msg);
    }

    protected ResponseEntity returnError(String msg) {
        return new ResponseEntity(400, null, msg);
    }
}
