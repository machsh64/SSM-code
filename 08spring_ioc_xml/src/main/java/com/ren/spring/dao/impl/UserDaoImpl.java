package com.ren.spring.dao.impl;

import com.ren.spring.dao.UserDao;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-21 17:27
 * @description:
 **/
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("用户信息被保存了");
    }
}
