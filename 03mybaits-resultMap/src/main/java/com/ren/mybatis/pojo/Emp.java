package com.ren.mybatis.pojo;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-14 17:14
 * @description:
 **/
public class Emp {

    private Integer empId;
    private String empName;
    private Integer age;
    private String gender;
    private Dept dept;

    public Emp() {
    }

    public Emp(String empName, Integer age, String gender) {
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }

    public Emp(String empName, Integer age, String gender, Dept dept) {
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
