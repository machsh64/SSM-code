package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-14 17:17
 * @description:
 **/
public interface EmpMapper {

    /**
    * @Description: 根据员工Id获取员工 在字段名与属性名不同的情况下
    * @Param: empId
    * @Author: Ren
    * @return: Emp
    * @Date: 2022/12/14 17:21
    */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
    * @Description: 获取员工以及所对应部门
    * @Param: empId
    * @Author: Ren
    * @return: Emp
    * @Date: 2022/12/14 18:36
    */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
    * @Description: 通过分布查询查询员工以及所对应的部门信息
    * @Param: empId
    * @Author: Ren
    * @return: Emp
    * @Date: 2022/12/14 19:22
    */
    Emp getEmpAndDeptByStep(@Param("empId") Integer empId);

    /**
    * @Description: 根据部门deptId查询所有员工信息
    * @Param: deptId
    * @Author: Ren
    * @return:  List<Emp>
    * @Date: 2022/12/15 16:35
    */
    List<Emp> getEmpListByDeptId(@Param("deptId") Integer deptId);
}
