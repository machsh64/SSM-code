package com.ren.spring.pojo;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-20 16:46
 * @description:
 **/
public class Clazz {

    private Integer cid;

    private String cname;

    private List<Student> studentList;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
