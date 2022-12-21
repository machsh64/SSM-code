package com.ren.spring.dao.impl;

import com.ren.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-21 19:26
 * @description:
 **/
@Repository
public class UserDaoImpl implements UserDao {

    public void saveUser(){
        System.out.println("人员信息保存完成");
    }
}
