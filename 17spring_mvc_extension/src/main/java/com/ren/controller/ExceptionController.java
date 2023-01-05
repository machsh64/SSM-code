package com.ren.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-05 18:57
 * @description:
 **/
// 将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    // 设置要处理的异常信息
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex,Model model){

        // ex标识控制器方法所出现的异常
        model.addAttribute("ex",ex);

        // 返回值为要跳转到的预设异常页面
        return "error";
    }
}
