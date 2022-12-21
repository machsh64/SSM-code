package com.ren.spring.controller;

import com.ren.spring.service.UserService;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-21 17:24
 * @description:
 **/
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
