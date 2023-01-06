package com.ren.ssm.mapper;

import com.ren.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-06 18:53
 * @description:
 **/
public interface EmployeeMapper {

    /**
    * @Description: 查找所有员工
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 19:33
    */
    List<Employee> getAllEmp();

    /**
    * @Description: 根据id查找员工
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:24
    */
    Employee getEmpById(@Param("empId") Integer empId);

    /**
    * @Description: 添加员工
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:14
    */
    Integer addEmp(Employee employee);

    /**
    * @Description: 修改员工信息
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:18
    */
    Integer updateEmp(Employee employee);

    /**
    * @Description: 删除员工信息
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:21
    */
    Integer deleteEmp(@Param("empId") Integer empId);
}
