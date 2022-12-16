package com.ren.mybatis.test;

import com.ren.mybatis.mapper.CacheMapper;
import com.ren.mybatis.pojo.Emp;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-16 17:39
 * @description:
 *
 *       MyBatis 的一级缓存：
 *       MyBatis 的一级缓存是SqlSession级别的，即通过同一个SqlSession查询的数据会被缓存
 *       再次使用同一个SqlSession查询同一个数据，不会再次执行sql语句，而会直接从缓存中获取
 *       使一级缓存失效的四种情况：
 *       1）不同的SqlSession对应不同的一级缓存
 *       2）同一个SqlSession但是查询条件不同
 *       3）同一个SqlSession两次查询期间执行了任何一次增删改操作
 *       4）同一个SqlSession两次查询期间手动清空了缓存
 *
 *       MyBatis 的二级缓存：
 *       MyBatis 的二级缓存是SqlSessionFactory级别的，即通过同一个SqlSessionFactory所获取的
 *       SqlSession对象查询的数据会被缓存，再通过同一个SqlSessionFactory所获取的SqlSession查询相同的数据会从缓存中获取
 *       MyBatis 二级缓存开启的条件
 *       a）在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
 *       b）在映射文件中设置标签<cache/>
 *       c）二级缓存必须在SqlSession关闭或提交之后有效
 *       d）查询的数据所转换的实体类类型i必须实现序列化的接口
 *       使二级缓存失效的情况：
 *       > 两次查询期间执行了任意的增删改，会使一级和二级缓存同时失效
 **/
public class CacheMapperTest {

    //二级缓存的测试
    @Test
    public void testCatch() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession1 = sessionFactory.openSession(true);

        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(2);
        System.out.println(emp1);
        CacheMapper mapper2 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(2);
        System.out.println(emp2);
        sqlSession1.close();        //此处关闭了SqlSession1后，SqlSession1中的数据进入了缓存，再次获取的SqlSession便可以获取到缓存中的数据

        SqlSession sqlSession2 = sessionFactory.openSession(true);
        CacheMapper mapper3 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper3.getEmpById(2);
        System.out.println(emp3);         //此时查询到的数据是从缓存中获取的，查询使用的是同一次sql
        sqlSession2.close();        //此处要进行关闭
    }

    // 一级缓存的测试
    @Test
    public void testGetEmpById() throws InterruptedException {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(2);
        System.out.println(emp1);
        /*Emp emp11 = new Emp("萧红", 21, "女");
        mapper1.insertEmp(emp11);*/      //同一个SqlSession两次查询期间，执行了一次增删改操作导致缓存失效
      /*  sqlSession1.clearCache();*/    //手动的清空缓存 导致SqlSession缓存失效
        Emp emp2 = mapper1.getEmpById(2);
        System.out.println(emp2);        // 以上两个对象均是由一个sql查询出来的

        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(2);
        System.out.println(emp3);      //这个对象是由第二个sql查询出来的   至此说明MyBatis的一级缓存是SqlSession级别的
    }

    @Test
    public void testInsertEmp() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = new Emp("萧红", 21, "女");
        mapper1.insertEmp(emp1);
    }
}
