package com.ren.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-23 17:46
 * @description: 1，在切面中，需要通过指定的注解将方法标识为通知方法
 *                  @Before : 前置通知，在目标对象方法执行之前执行
 *                  @After : 后置通知，在目标对象方法finally字句中执行
 *                  @AfterRetruning ：返回通知，在目标对象方法try字句中执行  正常执行后执行
 *                  @AfterThrowing ：异常通知，在目标对象方法catch字句中执行
 *
 *               2，切入点表达式：设置在标识通知的注解的value属性中
 *                  execution(public int com.ren.spring.aop.annotation.CalculatorImpl.add(int,int))
 *                  execution(* com.ren.spring.aop.annotation.CalculatorImpl.*(..))
 *                  第一个*表示任意的访问修饰符和返回值类型
 *                  第二个*表示类中任意的方法
 *                  .. 表示任意的参数列表
 *                  类的地方也可以使用* ， 表示包下所有的类
 *
 *               3，重用切入点表达式
 *               // @Pointcut声明一个公共的切入点表达式
 *                  @Pointcut("execution(* com.ren.spring.aop.annotation.CalculatorImpl.*(..))")
 *                  public void pointCut(){}
 *                 使用方式：
 *                  @Before("pointCut()")
 *                  @After("pointCut()")
 *
 *              4，获取连接点的信息
 *                  在通知方法的参数位置设置JoinPoint类型的参数，就可以获取连接点所对应方法的信息
 *               // 获取连接点所对应的方法的签名信息
 *                  String methodName = joinPoint.getSignature().getName();
 *              // 获取连接点对应的方法的参数列表
 *                  Object[] args = joinPoint.getArgs();
 *
 *              5，切面的优先级
 *                 可以通过@Order注解的value属性设置优先级，默认值Integer的最大值
 *                 @Order 注解的value属性值越小，优先级越高
 **/
@Component
public class LoggerAspect {



    // 环绕通知的方法的返回值一定要和目标对象方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知" );
            // 表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知" );
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->异常通知" );
        } finally {
            System.out.println("环绕通知-->后置通知" );
        }
        return result;
    }

    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // 获取连接点所对应的方法的签名信息
        String methodName = joinPoint.getSignature().getName();
        // 获取连接点对应的方法的参数列表
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("LoggerAspect, 前置通知 方法：" + methodName + "  参数：" + args);
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggerAspect, 返回通知 方法：" + methodName+" ，result："+result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggerAspect, 异常通知 方法：" + methodName + "，异常类型为："+exception);
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggerAspect, 后置通知 方法：" + methodName + " ，执行完毕");
    }
}
