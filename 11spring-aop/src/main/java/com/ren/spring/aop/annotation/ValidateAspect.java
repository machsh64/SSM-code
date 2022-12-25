package com.ren.spring.aop.annotation;

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
@Aspect
@Order(1)   //优先级 value的数字值越小越优先
@Component
public class ValidateAspect {

    @Pointcut("execution(* com.ren.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void beforeMethod(){
     System.out.println("ValidateAspect--> 前置通知");
    }
}
