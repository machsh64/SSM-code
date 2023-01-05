package com.ren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-05 17:13
 * @description:
 **/
@Controller
public class TestController {

    @RequestMapping("test/hello")
    public String testHello(){

        return "success";
    }
}
