package com.ren.mybatis.test;

import com.ren.mybatis.mapper.SpecialSqlMapper;
import com.ren.mybatis.pojo.User;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-13 19:26
 * @description:
 **/
public class SpecialSqlMapperTest {

    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> a = mapper.getUserByLike("a");
        a.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        Integer result = mapper.deleteMoreUser("9,10");
        System.out.println("结果为："+result);
        sqlSession.close();
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> a = mapper.getUserList("t_user");
        a.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User("testInsert3", "12345", 22, "男", "123@qq.com");  //此时此处的user实体类对象的id成员变量为0（int默认0）
        Integer result = mapper.insertUser(user);
        System.out.println("结果为："+result);
        System.out.println(user);  // User{id=13, username='testInsert3', password='12345', age=22, gender='男', email='123@qq.com'}  此时通过mapper中的获取自增主键并通过id属性赋值给了id成员变量
        sqlSession.close();
    }
}
