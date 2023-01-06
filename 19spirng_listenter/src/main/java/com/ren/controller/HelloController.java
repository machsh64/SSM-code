package com.ren.controller;

import com.ren.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-06 17:45
 * @description:
 **/
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

}
