package com.ren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-26 17:22
 * @description:
 **/
@Controller
public class HelloController {


    @RequestMapping("/index")
    public String protal(){

        // 将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }
}
