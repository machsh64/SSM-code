package com.ren.spring.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-22 16:44
 * @description:
 **/
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部，result：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部，result：" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部，result：" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部，result：" + result);
        return result;
    }
}
