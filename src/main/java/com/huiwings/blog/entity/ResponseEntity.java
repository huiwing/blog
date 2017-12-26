package com.huiwings.blog.entity;

/**
 * huiwings@163.com
 * Create By 2017/9/5 10:48
 */
public class ResponseEntity {
    private int resultCode;
    private Object data;
    private String msg;

    public ResponseEntity() {
    }

    public ResponseEntity(int resultCode, String msg) {
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public ResponseEntity(int resultCode, Object data, String msg) {
        this.resultCode = resultCode;
        this.data = data;
        this.msg = msg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
