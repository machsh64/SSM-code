package com.ren.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ren.ssm.pojo.Employee;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-06 18:44
 * @description:
 **/
public interface EmployeeService {

    /**
    * @Description: 查询所有员工
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:13
    */
    List<Employee> getAllEmp();

    /**
    * @Description: 查询员工的分页信息
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/7 18:10
    */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

        /**
        * @Description: 根据id查找员工
        * @Param:
        * @Author: Ren
        * @return:
        * @Date: 2023/1/6 20:26
        */
    Employee getEmpById(Integer empId);

    /**
    * @Description: 添加员工
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:17
    */
    Integer addEmp(Employee employee);

    /**
    * @Description: 修改员工信息
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:17
    */
    Integer updateEmp(Employee employee);

    /**
    * @Description: 删除员工
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2023/1/6 20:23
    */
    Integer deleteEmp(Integer empId);
}
