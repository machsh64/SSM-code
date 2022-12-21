package com.ren.spring.service.impl;

import com.ren.spring.dao.UserDao;
import com.ren.spring.service.UserService;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-21 17:25
 * @description:
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
