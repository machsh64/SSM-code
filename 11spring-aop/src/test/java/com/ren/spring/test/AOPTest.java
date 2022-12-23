package com.ren.spring.test;

import com.ren.spring.aop.annotation.Calculator;
import com.ren.spring.aop.annotation.CalculatorImpl;
import com.ren.spring.aop.annotation.LoggerAspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-23 18:00
 * @description:
 **/
public class AOPTest {

    @Test
    public void testAOPByAnnotation() {

        ApplicationContext application = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator bean = application.getBean(Calculator.class);
        bean.div(10,2);
    }
}
