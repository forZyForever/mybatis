package com.Nintendo.test;

import com.Nintendo.mybatis.dao.Userdao;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.Nintendo.mybatis.domain.User;
import com.Nintendo.mybatis.domain.account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class myTest {
    private SqlSession sqlSession;
    private InputStream is;
    private Userdao userdao;

    @Before
    public void init() {
        //1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //加载主配置文件,将主配置文件转换成流
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //3.构建出一个SqlSessionFactory工厂
            SqlSessionFactory SessionFactory = builder.build(is);
            //4通过工厂构建一个对象
            sqlSession = SessionFactory.openSession(true);
            //通过动态代理获得接口的代理对象
            userdao = sqlSession.getMapper(Userdao.class);
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

    //一个条件进行判断时,test后面写value!=null
    @Test
    public void testfindUser() {
        List<User> user = userdao.findUser("%马%");
        for (User user1 : user) {
            System.out.println(user1);
        }
    }
    //根据用户名和姓名查询用户
@Test
    public void testfindUserByIdAndUsername() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 3);
        map.put("username", "喷火龙");
        List<User> m = userdao.findUserByIdAndUsername(map);
        for (User user : m) {
            System.out.println(user);
        }
    }
    //根据传入的多个id查询用户
    @Test
  public void testfindUserByIds(){
        List<Integer> list=new ArrayList<Integer>();
        Collections.addAll(list,1,2,3,4,5);
        List<User> ids = userdao.findUserByIds(list);
        for (User id : ids) {
            System.out.println(id);
        }
    }
    //一对一进行查询
    @Test
    public void testfindAccountUserByAid(){
        account account = userdao.findAccountUserByAid(1);
        System.out.println(account);
    }
    //一对多查询
    @Test
    public void testfindAllAccountUserByid(){
        User user = userdao.findAllAccountUserByid(3);
        System.out.println(user);
    }
    //多对多查询
    @Test
    public void testfindUserRoleById(){
        User user = userdao.findUserRoleById(2);
        System.out.println(user);
    }
    //一对多(两次)
    @Test
    public void testfindUserAll(){
        User user = userdao.findUserAll(3);
        System.out.println(user);
    }
//同时一对一和一对多
    @Test
    public void testfindUserTrueAll(){
        User user = userdao.findUserTrueAll(3);
        System.out.println(user);
    }
}
