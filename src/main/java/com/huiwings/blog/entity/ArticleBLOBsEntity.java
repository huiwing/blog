package com.huiwings.blog.entity;

/**
 * huiwings@163.com
 * Create By 2017/12/26 14:20
 */
public class ArticleBLOBsEntity extends ArticleEntity {
    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
