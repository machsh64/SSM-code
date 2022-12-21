package com.rem.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ren.mybatis.mapper.EmpMapper;
import com.ren.mybatis.pojo.Emp;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-16 21:40
 * @description: 分页插件测试
 **/
public class PageTest {

    /**
    * PageInfo{
     * pageNum=1, pageSize=4, size=4,
     * startRow=1, endRow=4, total=30,
     * pages=8,
     * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=30, pages=8, reasonable=false, pageSizeZero=false}
     * [Emp{empId=1, empName='a', age=null, gender='null', deptId=null},
     * Emp{empId=2, empName='b', age=null, gender='null', deptId=null},
     * Emp{empId=3, empName='c', age=null, gender='null', deptId=null},
     * Emp{empId=4, empName='d', age=null, gender='null', deptId=null}],
     * prePage=0, nextPage=2,
     * isFirstPage=true, isLastPage=false,
     * hasPreviousPage=false, hasNextPage=true,
     * navigatePages=5,
     * navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}
    * */

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页
        Page<Object> page = PageHelper.startPage(5, 4);
        List<Emp> emps = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(emps,5);  //导航分页的页码数
        emps.forEach(System.out::println);
        System.out.println(page);
        System.out.println("");
        System.out.println(pageInfo);
    }
}
