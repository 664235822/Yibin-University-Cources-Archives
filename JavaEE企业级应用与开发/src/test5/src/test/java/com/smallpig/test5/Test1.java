package com.smallpig.test5;

import com.smallpig.User.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {

    public SqlSession getSession() throws IOException {//独立一个方法去获取SqlSession
        String source="mybatis-config.xml";
        InputStream stream= Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory=
                new SqlSessionFactoryBuilder().build(stream);
        return sqlSessionFactory.openSession();
    }

    @Test
    public void listUser() throws IOException {
        String source="mybatis-config.xml";//声明mybatis配置文件的位置
        InputStream stream= Resources.getResourceAsStream(source);
        //使用ibatis.io.Resources获取IO流  注意添加抛出异常
        SqlSessionFactory sqlSessionFactory=
                new SqlSessionFactoryBuilder().build(stream);//根据IO流创建SqlSessionFactory对象
        try (SqlSession session = sqlSessionFactory.openSession()) {//打开对数据库访问，看做一次会话
            List<User> list = session.selectList("com.smallpig.Mapper.UsersMapper.listUsers");
            //执行查询所有数据的方法，其中参数为对应UserMapper.xml文件中的域名空间"zyd.myBatisDemo.UserMapper"
            // +查询id名(listUser) 将多个查询结果封装成List<User>类型的对象
            for (User user : list) {//增强for循环打印查询结果
                System.out.println("user:" + user);
            }
        } catch (Exception e) {
            e.printStackTrace();//打印报错信息
        }
    }



    @Test
    public void selectUserOne() throws IOException {
        String source="mybatis-config.xml";
        InputStream stream= Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory=
                new SqlSessionFactoryBuilder().build(stream);
        try(SqlSession session=sqlSessionFactory.openSession()){
            //单值传递，2作为id参数传入
            User user=session.selectOne("com.smallpig.Mapper.UsersMapper.selectUserOne",2);
            System.out.println("user:"+user);
        }catch (Exception e){
            e.printStackTrace();//打印报错信息
        }
    }
    @Test
    public void deleteById() throws IOException {
        SqlSession session=getSession();
        int row=session.delete("com.smallpig.Mapper.UsersMapper.deleteById",5);
        System.out.println("row="+row);
        session.commit();
    }

    @Test
    public void insertUser() throws IOException {
        User user=new User();
        user.setId(55);
        user.setUser("张三2");
        user.setAge(20);
        user.setSex("男");
        SqlSession session=getSession();
        int row=session.insert("com.smallpig.Mapper.UsersMapper.insertUser",user);
        System.out.println("row="+row);
        session.commit();
        session.close();
    }

}
