package com.Nintendo.mybatis.domain;

import java.util.List;

public class Role {
   private Integer rid;
   private String rname;
   private String rdesc;
   private List<User> user; //角色和用户表的一对多

    public Role() {
    }

    public Role(Integer id, String rname, String rdesc, List<User> user) {
        this.rid = id;
        this.rname = rname;
        this.rdesc = rdesc;
        this.user = user;
    }

    public Integer getId() {
        return rid;
    }

    public void setId(Integer id) {
        this.rid = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + rid +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                ", user=" + user +
                '}';
    }
}
