package com.ren.mybatis.test;

import com.ren.mybatis.mapper.DeptMapper;
import com.ren.mybatis.mapper.EmpMapper;
import com.ren.mybatis.pojo.Dept;
import com.ren.mybatis.pojo.Emp;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-14 17:18
 * @description:
 **/
public class ResultMapTest {

    @Test
    public void testGetEmpByEmpId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(2);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByEmpId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(2);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStep(2);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpByDeptIdByCollection() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptIdByCollection(1);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpByDeptIdByStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptIdByStep(1);
        System.out.println(dept);
        sqlSession.close();
    }
}
