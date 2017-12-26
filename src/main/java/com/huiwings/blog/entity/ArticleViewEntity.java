package com.huiwings.blog.entity;

/**
 * huiwings@163.com
 * Create By 2017/12/26 15:00
 */
public class ArticleViewEntity extends ArticleBLOBsEntity {
    private String username;
    private String email;
    private String nickname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
