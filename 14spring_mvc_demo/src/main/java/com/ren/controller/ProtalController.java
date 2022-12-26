package com.ren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-26 18:41
 * @description:
 **/
@Controller
@RequestMapping("protal")
public class ProtalController {

    //访问首页
    @RequestMapping("/index")
    public String protal(){

        return "index";
    }
}
