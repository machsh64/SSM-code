package com.ren.mybatis.test;

import com.ren.mybatis.mapper.DynamicSQLMapper;
import com.ren.mybatis.pojo.Emp;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-15 18:26
 * @description: 测试
 **/
public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,null,22,"男");
        List<Emp> empList = mapper.getEmpByCondition(emp);
        empList.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,null,22,"男");
        List<Emp> empList = mapper.getEmpByChoose(emp);
        empList.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = new LinkedList<>();
        Emp emp = new Emp(null,"黎明",23,"男");
        Emp emp2 = new Emp(null,"孙权",21,"男");
        Emp emp3 = new Emp(null,"广志",33,"男");
        emps.add(emp);
        emps.add(emp2);
        emps.add(emp3);
        Integer integer = mapper.insertMoreEmp(emps);
        System.out.println("num: " + integer);
        System.out.println(emp.getEmpId());
    }

    @Test
    public void testDeleteMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{11,8};
        Integer integer = mapper.deleteMoreEmp(empIds);
        System.out.println("num: " + integer);
    }
}
