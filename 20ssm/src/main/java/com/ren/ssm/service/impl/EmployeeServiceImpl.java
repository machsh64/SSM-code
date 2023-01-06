package com.ren.ssm.service.impl;

import com.ren.ssm.mapper.EmployeeMapper;
import com.ren.ssm.pojo.Employee;
import com.ren.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-06 18:44
 * @description:
 **/
@Service
@Transactional
 public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmp() {
        return employeeMapper.getAllEmp();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmpById(Integer empId) {
        return employeeMapper.getEmpById(empId);
    }

    @Override
    public Integer addEmp(Employee employee) {
        return employeeMapper.addEmp(employee);
    }

    @Override
    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }

    @Override
    public Integer deleteEmp(Integer empId) {
        return employeeMapper.deleteEmp(empId);
    }
}
