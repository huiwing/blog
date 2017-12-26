package com.huiwings.blog.controller.base;

import com.huiwings.blog.entity.ResponseEntity;
import com.huiwings.blog.http.ResponseCode;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:28
 */
public class BaseController {
    protected ResponseEntity returnOk(String msg) {
        return new ResponseEntity(ResponseCode.REQUEST_OK, msg);
    }

    protected ResponseEntity returnOk(Object obj, String msg) {
        return new ResponseEntity(ResponseCode.REQUEST_OK, obj, msg);
    }

    protected ResponseEntity returnError(String msg) {
        return new ResponseEntity(ResponseCode.REQUEST_ERROR, msg);
    }

    protected ResponseEntity returnError() {
        return new ResponseEntity(ResponseCode.REQUEST_ERROR, "请求失败");
    }

    protected ResponseEntity returnError(int code, String msg) {
        return new ResponseEntity(code, msg);
    }


    /**
     * 解析返回
     *
     * @param code
     * @return
     */
    protected ResponseEntity returnResult(int code) {
        ResponseEntity repEntity;
        switch (code) {
            case ResponseCode.REQUEST_OK:
                repEntity = new ResponseEntity(code, "请求成功");
                break;
            case ResponseCode.REQUEST_ERROR:
                repEntity = new ResponseEntity(code, "请求失败");
                break;
            case ResponseCode.NO_PERMISSION:
                repEntity = new ResponseEntity(code, "没有权限");
                break;
            default:
                repEntity = new ResponseEntity(code, "未知错误");
                break;
        }
        return repEntity;
    }

}
