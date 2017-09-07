package com.huiwings.blog.entity;

/**
 * huiwings@163.com
 * Create By 2017/9/5 10:26
 */
public class UserEntity {
    private Integer id;
    private String username;
    private String nickname;
    private String email;
    private int age;
    private String create_time;
    private String timestamp;

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreatetime() {
        return create_time;
    }

    public void setCreatetime(String createtime) {
        this.create_time = createtime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", create_time='" + create_time + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
