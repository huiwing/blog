package com.huiwings.blog.entity;

/**
 * huiwings@163.com
 * Create By 2017/9/7 10:45
 */
public class ArticleEntity {
    private Integer aid;

    private Integer typeCode;
    private Integer uid;

    private String createTime;

    private String ts;

    private Integer dr;

    private Integer cLike;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Integer getcLike() {
        return cLike;
    }

    public void setcLike(Integer cLike) {
        this.cLike = cLike;
    }
}
