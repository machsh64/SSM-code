package com.ren.controller;

import com.ren.dao.EmployeeDao;
import com.ren.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-03 19:24
 * @description:
 *    查询所有的员工信息 --> /employee --> get
 *       跳转到添加页面 --> /to/add --> get
 *         添加员工信息 --> /employee --> post
 *       跳转到修改页面 --> /employee/1 --> get
 *         修改员工信息 --> /employee --> put
 *         删除员工信息 --> /employee/1 --> delete
 **/
@Controller
public class EmployeeController {

    @Resource
    EmployeeDao employeeDao;

    @RequestMapping("/employee")
    public String getAllEmployee(Model model){
        // 获取所有员工信息
        Collection<Employee> employees = employeeDao.getAll();
        // 将所有员工信息在请求与中共享
        model.addAttribute("allEmployee",employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        // 跳转到列表页面
        return "employee_list";
    }

    @RequestMapping("/to/add")
    public String toAddPage(){
        return "employee_add";
    }

    @PostMapping("/employee")
    public String saveEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping("/employee/{employeeId}")
    public String toUpdatePage(@PathVariable("employeeId") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "/employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployeeById(@PathVariable("employeeId") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
