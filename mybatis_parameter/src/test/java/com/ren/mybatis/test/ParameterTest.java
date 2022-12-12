package com.ren.mybatis.test;

import com.ren.mybatis.mapper.UserMapper;
import com.ren.mybatis.pojo.User;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-12 18:30
 * @description:
 **/
public class ParameterTest {

    @Test
    public void testGetUserByUserName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUserName("root");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("root", "123");
        System.out.println(user);
        sqlSession.close();
    }
}
