package com.Nintendo.domain;
/*JavaBean类中的属性还是JavaBean类型*/
public class QueryVo {
    private User user;

    public QueryVo() {
    }

    public QueryVo(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
