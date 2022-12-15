package com.ren.mybatis.pojo;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-14 17:16
 * @description:
 **/
public class Dept {

    private Integer deptId;
    private String deptName;
    private List<Emp> emps;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Dept(Integer deptId, String deptName, List<Emp> emps) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.emps = emps;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
