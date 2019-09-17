package com.Nintendo.dao;

import com.Nintendo.domain.QueryVo;
import com.Nintendo.domain.User;
import com.Nintendo.domain.Userinfo;

import java.util.List;
import java.util.Map;

public interface Userdao {

    List<User> findAll();

    int addUser(User user);

    int DeleteUserById(int id);

    int UpdateUserById(Map<String, Object> map);

    int UpdateUserByI(User user);

    User QueryUserByid(int id);

    Map<String, Object> QueryUserByi(int id);

    String QueryUserByusername(int id);

    long QueryUserCount();

    List<User> QueryUserByLike(String name);

    List<User> QueryUserByLik(String name);

    List<User> QueryUserByJavabean(QueryVo vo);

    Userinfo findUserinfoById(int id);
}
