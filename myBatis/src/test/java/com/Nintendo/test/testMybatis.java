package com.Nintendo.test;

import com.Nintendo.dao.Userdao;
import com.Nintendo.domain.QueryVo;
import com.Nintendo.domain.User;
import com.Nintendo.domain.Userinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class testMybatis {

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

    //查询所有用户
    @Test
    public void testFindAll() {
        List<User> all = userdao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }

    //添加用户
    @Test
    public void testaddUser() {
        User user = new User(null, "新恒结衣", "女", "东京", new Date());
        userdao.addUser(user);
        System.out.println(user);
    }

    //删除用户
    @Test
    public void testDeleteUserById() {
        userdao.DeleteUserById(58);
    }

    /*修改时传入的参数为map*/
    @Test
    public void testUpdateUserById() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "新垣结衣");
        map.put("address", "世田谷");
        map.put("id", 4);
        userdao.UpdateUserById(map);
    }

    /*修改时传入的参数为user对象*/
    @Test
    public void test02UpdateUserByI() {
        User user = new User();
        user.setUsername("马里奥");
        user.setAddress("东京");
        user.setId(4);
        userdao.UpdateUserByI(user);
    }

    //查询用户并把它封装到一个对象中
    @Test
    public void testQueryUserByid() {
        User user = userdao.QueryUserByid(4);
        System.out.println(user);
    }

    //查询用户并把它封装到一个map中去
    @Test
    public void testQueryUserByi() {
        Map<String, Object> map = userdao.QueryUserByi(4);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    //查询用户返回他的姓名
    @Test
    public void testQueryUserByusername() {
        String username = userdao.QueryUserByusername(4);
        System.out.println(username);
    }

    //查询用户总数量
    @Test
    public void testQueryUserCount() {
        long i = userdao.QueryUserCount();
        System.out.println(i);
    }

    //模糊查询方法一
    @Test
    public void testQueryUserByLike() {
        String name = "马";
        List<User> users = userdao.QueryUserByLike("%" + name + "%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    //模糊查询方法二
    @Test
    public void testQueryUserByLik() {
        String username = "马";
        List<User> users = userdao.QueryUserByLik(username);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //如果JavaBean中的属性还是JavaBean类型
    @Test
    public void testQueryUserByJavabean() {
        //查询时先给user的属性赋值
        //在把user传入queryvo对象中去
        User user = new User();
        user.setUsername("%马%");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> users = userdao.QueryUserByJavabean(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
   // 查询到的结果集的字段名和要封装结果的JavaBean的属性名不一致
    @Test
  public void testfindUserinfoById(){
      Userinfo userinfo = userdao.findUserinfoById(4);
      System.out.println(userinfo);
  }
}
