package com.rem.mybatis.test;

import com.ren.mybatis.mapper.EmpMapper;
import com.ren.mybatis.pojo.Emp;
import com.ren.mybatis.pojo.EmpExample;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-16 19:49
 * @description:
 **/
public class MBGTest {

    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据id查询数据
       /* Emp emp = mapper.selectByPrimaryKey(2);
        System.out.println(emp);*/
        //查询所有数据
       /* List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);*/
        //根据条件查询数据
      /*  EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("广志").andGenderEqualTo("男");   // 添加多条件即可继续在之后进行补充
        example.or().andAgeEqualTo(21);   // 另起一行 example用or()进行连接， 则将条件变成了 上面一行条件，或者 这一行条件 满足的数据
        List<Emp> empList = mapper.selectByExample(example);
        empList.forEach(System.out::println);*/

        //测试普通修改功能
        Emp emp = new Emp(1,null, 22, null);
        /*int i = mapper.updateByPrimaryKey(emp);  //此项修改，若实体类型中某属性为null，则会修改数据库中数据为null
        System.out.println("num:"+i);*/
        //测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);  //此项修改，若实体类型中某属性为null，则不会修改数据库中数据为null

        //根据条件批量删除数据
        /*EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpIdBetween(18,30);
        int i = mapper.deleteByExample(empExample);
        System.out.println("num:"+i);*/

    }
}
