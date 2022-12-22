package com.ren.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-22 17:31
 * @description:  代理模式之动态代理
 **/
public class ProxyFactory<T> {

    private final T target;

    public ProxyFactory(T target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public T getProxy() {
        /**
         *  ClassLoader loader;  指定加载动态生成的代理类的类加载器
         *  Class[] interfaces;  获取目标对象实现的所有接口的class对象的数组
         *  InvocationHandler h; 设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            // proxy 表示代理对象 ， method 表示要执行的方法 ， args表示要执行的方法的参数列表
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result =null;
                try{
                    System.out.println("日志，方法："+method.getName()+" ，参数："+ Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("日志，方法："+method.getName()+" ，结果："+ result);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("日志，方法："+method.getName()+" ，异常："+ e);
                }finally {
                    System.out.println("日志，方法："+method.getName()+" ，方法执行完毕");
                }
                return result;
            }
        };

        return (T) Proxy.newProxyInstance(classLoader, interfaces, h);
    }
}
