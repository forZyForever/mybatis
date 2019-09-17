package com.Nintendo.mybatis.dao;

import com.Nintendo.mybatis.domain.account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface Accountdao {
    //根据账号的aid查询账号信息，并且调用外部查询获取该账号的用户信息(一对一映射)
    //方法一
    @Results({
            @Result(column = "id", property = "user.id"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "birthday", property = "user.birthday"),
            @Result(column = "sex", property = "user.sex"),
            @Result(column = "address", property = "user.address")
    })
    @Select("SELECT * FROM USER u,account a WHERE u.id=a.uid AND aid=1")
    account findaccountById(int aid);
    //方法二
    @Results({
            @Result(property = "uid",column = "uid"),
            @Result(property = "user",column = "uid",one = @One(select = "com.Nintendo.mybatis.dao.Userdao.findByUserId"))
    })
    @Select("select * from account where aid=#{aid}")
    account findaccountByaid(int aid);
   //根据用户id查询所有账号
    @Select("select * from account where uid=#{uid}")
    account findaccountByUid(int uid);
     //配置文件一对一方法
    account findAcByaid(int aid);
    //配置文件一对多方法
   account findaccountss(int uid);
}
