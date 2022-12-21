package com.ren.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-12 15:44
 * @description:
 **/
public class SqlSessionUtil {

    public static ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();

    public static SqlSession getSqlSession() {
        // 获取核心配置文件的输入流
        InputStream is = null;
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if (sqlSession == null) {
            try {
                is = Resources.getResourceAsStream("mybatis-config.xml");
                // 获取SqlSessionFactoryBuilder
                SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
                // 获取sqlSessionFactory
                SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
                // 由sqlSessionFactory获取sqlSession
                sqlSession = sqlSessionFactory.openSession(true);
                sqlSessionThreadLocal.set(sqlSession);
                System.out.println("SqlSession build true...");
            } catch (IOException e) {
                System.out.println("SqlSession build false...");
                e.printStackTrace();
            }
        }
        return sqlSessionThreadLocal.get();
    }

    public static void closeQuietly(){
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        sqlSession.close();
        sqlSessionThreadLocal.set(null);
        System.out.println("SqlSession close...\n");
    }
}
