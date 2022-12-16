package com.ren.mybatis.pojo;

import java.io.Serializable;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-15 18:13
 * @description:
 **/
public class Emp implements Serializable {

    private Integer empId;
    private String empName;
    private Integer age;
    private String gender;

    public Emp() {
    }

    public Emp(String empName, Integer age, String gender) {
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }

    public Emp(Integer empId, String empName, Integer age, String gender) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
