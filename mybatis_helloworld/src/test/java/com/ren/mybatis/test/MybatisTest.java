package com.ren.mybatis.test;

import com.ren.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-10 21:49
 * @description:
 **/
public class MybatisTest {
    @Before
    public void before(){

    }

    @Test
    public void testInsert() {
        try {
            // 获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 获取SQLSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            // 获取sql的对话对象SqlSession，是MyBatis提供的操作数据库的对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            // 获取UserMapper的代理实现类对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 调用mapper接口中的方法，实现添加用户信息的功能
            int result = mapper.insertUser();
            System.out.println("结果：" + result);
            sqlSession.commit();
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
