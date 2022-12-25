package com.ren.spring.test;

import com.ren.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 17:40
 * @description:
 **/
public class AOPByXMLTest {

    @Test
    public void testAOPByXML() {
        ApplicationContext application =  new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = application.getBean(Calculator.class);
        calculator.add(1,2);
    }
}
