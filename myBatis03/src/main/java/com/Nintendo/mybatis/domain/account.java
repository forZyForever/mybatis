package com.Nintendo.mybatis.domain;

public class account {
   private Integer aid;
   private Double money;
   private Integer uid;
   private User user;

    public account() {
    }

    public account(Integer aid, Double money, Integer uid, User user) {
        this.aid = aid;
        this.money = money;
        this.uid = uid;
        this.user = user;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "account{" +
                "aid=" + aid +
                ", money=" + money +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }


}
