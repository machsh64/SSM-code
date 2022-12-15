package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-15 18:15
 * @description:
 **/
public interface DynamicSQLMapper {

    /**
    * @Description: 根据条件查询员工信息
    * @Param: Emp emp
    * @Author: Ren
    * @return: List<Emp>
    * @Date: 2022/12/15 18:17
    */
    List<Emp> getEmpByCondition(Emp emp);

    /**
    * @Description: 使用choose查询员工信息
    * @Param:  Emp emp
    * @Author: Ren
    * @return:  List<Emp>
    * @Date: 2022/12/15 19:23
    */
    List<Emp> getEmpByChoose(Emp emp);

    /**
    * @Description: 使用foreach标签添加多个员工
    * @Param: List<Emp> emps
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/15 19:43
    */
    Integer insertMoreEmp(@Param("emps") List<Emp> emps);

    /**
    * @Description: 使用foreach标签删除多个员工
    * @Param: Integer[] empIds
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/15 20:22
    */
    Integer deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
