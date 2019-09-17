package com.Nintendo.test;

import com.Nintendo.mybatis.dao.Accountdao;
import com.Nintendo.mybatis.dao.Userdao;
import com.Nintendo.mybatis.domain.User;
import com.Nintendo.mybatis.domain.Userinfo;
import com.Nintendo.mybatis.domain.account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private InputStream is;
    private SqlSession sqlSession;
    private Userdao userdao;
    private SqlSessionFactory sessionFactory;
    private Accountdao accountdao;


    @Before
    public void init() {
        //1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //加载主配置文件,将主配置文件转换成流
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //3.构建出一个SqlSessionFactory工厂
            sessionFactory = builder.build(is);
            //4通过工厂构建一个对象
            sqlSession = sessionFactory.openSession(true);
            //通过动态代理获得接口的代理对象
            userdao = sqlSession.getMapper(Userdao.class);
            accountdao = sqlSession.getMapper(Accountdao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭流
    @After
    public void destroy() throws IOException {
        sqlSession.close();
        is.close();
    }

    @org.junit.Test
    public void Demo01() {
        List<User> all = userdao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void Demo02() {
        User user = userdao.findByUserId(4);
        System.out.println(user);
    }

    @org.junit.Test
    public void Demo03() {
        List<User> user = userdao.findLikeUser("%马%");
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @org.junit.Test
    public void Demo04() {
        List<User> user = userdao.findLike02User("马");
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @org.junit.Test
    public void Demo05() {
       userdao.deleteUserById(1);
    }

    @org.junit.Test
    public void Demo06() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "耿鬼");
        map.put("add", "名古屋");
        map.put("id", 2);
        userdao.updateUserById(map);
    }
    @org.junit.Test
    public void Demo07() {
        Userinfo userinfo = userdao.findUserByUserinfo(3);
        System.out.println(userinfo);
    }
    @org.junit.Test
    public void Demo08() {
        account account = accountdao.findaccountById(1);
        System.out.println(account);
    }
    @org.junit.Test
    public void Demo09() {
        account account = accountdao.findaccountByaid(1);
        System.out.println(account);
    }
    @org.junit.Test
    public void Demo10() {
        User accounts = userdao.findAccountsByUserId(3);
        System.out.println(accounts);
    }
    @org.junit.Test
    public void Demo11() {
        account byaid = accountdao.findAcByaid(1);
        System.out.println(byaid);
    }
    @org.junit.Test
    public void Demo12() {
        User user = userdao.finduse(3);
        System.out.println(user);
    }
    @org.junit.Test
    public void Demo13() {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("a","星之卡比");
        map.put("b",new Date());
        map.put("c","男");
        map.put("d","梦幻岛");
      userdao.insertUserIndex(map);
      Object id = map.get("id");
        System.out.println(id);
    }

}
