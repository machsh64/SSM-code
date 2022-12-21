package com.ren.spring.service.impl;

import com.ren.spring.dao.UserDao;
import com.ren.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-21 19:25
 * @description:
 **/
@Service()
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(){
        userDao.saveUser();
    }
}
