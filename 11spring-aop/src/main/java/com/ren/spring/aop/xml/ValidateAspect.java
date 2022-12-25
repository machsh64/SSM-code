package com.ren.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 17:15
 * @description:
 **/
@Component
public class ValidateAspect {

    public void beforeMethod(){
     System.out.println("ValidateAspect--> 前置通知");
    }
}
