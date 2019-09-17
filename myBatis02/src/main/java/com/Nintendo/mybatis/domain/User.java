package com.Nintendo.mybatis.domain;

import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private String username;
    private String sex;
    private String address;
    private Date birthday;
    private List<account> account;//用户和账号的一对多
    private List<Role> role;  //用户和角色的一对多
    private Card card;//用户和身份证的一对一

    public User() {
    }

    public User(Integer id, String username, String sex, String address, Date birthday, List<com.Nintendo.mybatis.domain.account> account, List<Role> role, Card card) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.account = account;
        this.role = role;
        this.card = card;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<com.Nintendo.mybatis.domain.account> getAccount() {
        return account;
    }

    public void setAccount(List<com.Nintendo.mybatis.domain.account> account) {
        this.account = account;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", account=" + account +
                ", role=" + role +
                ", card=" + card +
                '}';
    }
}
