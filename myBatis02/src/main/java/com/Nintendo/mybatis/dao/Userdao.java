package com.Nintendo.mybatis.dao;

import com.Nintendo.mybatis.domain.User;
import com.Nintendo.mybatis.domain.account;

import java.util.List;
import java.util.Map;

public interface Userdao {

    List<User> findUser(String username);

    List<User> findUserByIdAndUsername(Map<String, Object> map);

    List<User> findUserByIds(List<Integer> ids);

    account findAccountUserByAid(int aid);

    User findAllAccountUserByid(int id);

    User findUserRoleById(int id);

    User findUserAll(int id);

    User findUserTrueAll(int id);

}
