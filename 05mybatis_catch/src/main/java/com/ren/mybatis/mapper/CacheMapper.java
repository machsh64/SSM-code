package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-16 17:34
 * @description:
 **/
public interface CacheMapper {

    /**
    * @Description: 根据员工Id查询员工信息
    * @Param: empId
    * @Author: Ren
    * @return: Emp
    * @Date: 2022/12/16 17:37
    */
    Emp getEmpById(@Param("empId") Integer EmpId);

    /**
    * @Description: 添加员工信息
    * @Param: emp
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/16 17:56
    */
    Integer insertEmp(Emp emp);
}
