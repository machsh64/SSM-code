package com.ren.ssm.controller;

import com.ren.ssm.pojo.Employee;
import com.ren.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-06 18:28
 * @description:
 * 查询所有的员工信息 --> /employee --> get
 * 查询员工的分页信息 --> /employee/page/1 --get
 *    跳转到添加页面 --> /to/add --> get
 *      添加员工信息 --> /employee --> post
 *    跳转到修改页面 --> /employee/1 --> get
 *      修改员工信息 --> /employee --> put
 *      删除员工信息 --> /employee/1 --> delete
 **/
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String toEmpList(Model model){
        // 查询所有员工信息
        List<Employee> allEmp = employeeService.getAllEmp();
        // 将员工信息在请求域中共享
        model.addAttribute("empList",allEmp);
        return "emp_list";
    }

//    @RequestMapping("/employee/page/{page}")
//    public String getEmpPage(Model model,@PathVariable("page") Integer page){
//        // 获取员工的分页信息
//    }

    @RequestMapping(value = "/to/add",method = RequestMethod.GET)
    public String toAddPage(){
      return "employee_add";
    }

    @PostMapping("/employee")
    public String addEmp(Employee employee){
        employeeService.addEmp(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.GET)
    public String toUpdatePage(Model model,@PathVariable("empId") Integer empId){
        Employee employee = employeeService.getEmpById(empId);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{empId}")
    public String deleteEmp(@PathVariable("empId") Integer empId){
        employeeService.deleteEmp(empId);
        return "redirect:/employee";
    }

}
