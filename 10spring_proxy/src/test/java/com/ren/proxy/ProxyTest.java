package com.ren.proxy;

import com.ren.spring.proxy.Calculator;
import com.ren.spring.proxy.CalculatorImpl;
import com.ren.spring.proxy.CalculatorStaticProxy;
import com.ren.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-22 17:23
 * @description:
 **/
public class ProxyTest {

    /***
     * 动态代理有两种：
     *  1，jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口
     *     在com.sun.proxy包下，类名为$proxy2
     *  2，cglib动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */

    @Test
    public void testProxy() {
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }

    @Test
    public void testProxyFactory() {
        ProxyFactory<Calculator> proxyFactory = new ProxyFactory<>(new CalculatorImpl());
        Calculator calculator = proxyFactory.getProxy();
        calculator.add(1,6);
    }
}
