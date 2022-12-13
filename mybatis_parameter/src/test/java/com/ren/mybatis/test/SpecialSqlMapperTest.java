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
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        Integer result = mapper.deleteMoreUser("9,10");
        System.out.println("结果为："+result);
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> a = mapper.getUserList("t_user");
        a.forEach(System.out::println);
    }
}
