package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-14 19:28
 * @description:
 **/
public interface DeptMapper {

    /**
    * @Description: 通过分步查询查询员工以及所对应部门信息的第二步
    * @Param: deptId
    * @Author: Ren
    * @return: Dept
    * @Date: 2022/12/14 19:31
    */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
    * @Description: 根据deptId查询部门以及部门中员工的信息 通过collection标签
    * @Param: deptId
    * @Author: Ren
    * @return: Dept
    * @Date: 2022/12/15 16:29
    */
    Dept getDeptAndEmpByDeptIdByCollection(@Param("deptId") Integer deptId);

    /**
    * @Description: 根据deptId查询部门以及部门中员工的信息 通过collection标签
    * @Param: deptId
    * @Author: Ren
    * @return: Dept
    * @Date: 2022/12/15 17:16
    */
    Dept getDeptAndEmpByDeptIdByStep(@Param("deptId") Integer deptId);
}
