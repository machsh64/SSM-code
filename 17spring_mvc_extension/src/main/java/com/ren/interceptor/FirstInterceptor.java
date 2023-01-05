package com.ren.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-05 17:23
 * @description:
 *
 *   拦截器的三个方法：
 *     preHandle() ：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截(false)或放行(true)
 *     postHandle() ：在控制器方法执行之后执行
 *     afterHandle() ：在控制器方法执行之后，且渲染视图完毕之后执行
 *
 *   多个拦截器的执行顺序和在SpringMVC的配置文件中配置的顺序有关
 *     preHandle() 按配置的顺序执行 ，而postHandle() 和 afterHandle()按照配置的反序执行
 *
 *   若拦截器中有某个拦截器的preHandle()返回了false
 *     拦截器的preHandle()返回false和他之前的拦截器preHandle()都会执行
 **/
@Component
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor --> preHandle ...");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor --> postHandle ...");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor --> afterHandle ...");

    }
}
