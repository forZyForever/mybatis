package com.Nintendo.mybatis.dao;

import com.Nintendo.mybatis.domain.User;
import com.Nintendo.mybatis.domain.Userinfo;
import org.apache.ibatis.annotations.*;


import java.util.List;
import java.util.Map;

public interface Userdao {
    //查询所有用户
    @Select("select * from user")
    List<User> findAll();

    //根据用户的id查询单个用户
    @Select("select * from user where id=#{id}")
    User findByUserId(int id);

    //根据用户名进行模糊查询
    @Select("select * from user where username like #{username}")
    List<User> findLikeUser(String name);

    @Select("select * from user where username like '%${value}%'")
    List<User> findLike02User(String name);

    //根据id删除某个用户
    @Delete("delete from user where id=#{id}")
    int deleteUserById(int id);

    @Update("update user set username=#{name},address=#{add} where id=#{id}")
    int updateUserById(Map<String, Object> map);

    //根据id查询单个用户信息，并且将用户信息封装到UserInfo对象中(结果集的字段名和JavaBean的属性名不能完全对应)
    @Results(id = "result01", value = {
            @Result(column = "id", property = "userId"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(column = "address", property = "userAddress")
    })
    @Select("select * from user where id=#{id}")
    Userinfo findUserByUserinfo(int id);

    //根据用户的id查询用户信息，并且调用外部查询获取该用户的所有账号(一对多的映射)
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account", column = "id", many = @Many(select = "com.Nintendo.mybatis.dao.Accountdao.findaccountByUid"))
    })
    @Select("select * from user where id=#{id}")
    User findAccountsByUserId(int id);

    //配置文件一对一方法
    User findUserAll(int id);
    //配置文件一对多方法
    User finduse(int id);

 int insertUserIndex(Map<String,Object> map);
}
