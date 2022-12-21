package com.ren.spring.controller;

import com.ren.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-21 19:24
 * @description:
 **/
@Controller("user")
public class UserController {

    @Resource(name = "userServiceImpl")
    //@Autowired@Qualifier("userServiceImpl")
    private UserService userService;

    /*@Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }*/

    /*@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public void saveUser(){
        userService.saveUser();
    }
}
