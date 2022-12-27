package com.ren.controller;

import com.ren.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-27 16:46
 * @description:
 *
 *    获取请求参数的方式：
 *    1，通过servletAPI获取
 *      只需要在控制器方法的形参位置设置HttpServletRequest类型的形参就可以在控制器中使用request对象获取请求参数
 *    2，通过控制器方法的形参获取
 *      只需要在控制器方法的形参位置，设置一个形参，这个形参的名字与请求参数的名字一样，即可获取到
 *    3，@RequestParam：将请求参数和控制器方法的参数绑定
 *       value ：设置和形参绑定的请求参数的名字
 *       required ：设置是否必须传输value所对应的请求参数
 *                  默认值为true,表示value所对应的请求参数必须传输，否则页面报错，400 - Required String parameter ‘xxx’ is not present
 *                  若设置为false，则表示value所对应的请求参数不是必须传输，若为传输，则形参值为null
 *       defaultValue ：设置当没有传输value所对应的请求参数时，为形参设置的默认值，此时和required属性值是否为false无关
 *    4，@RequestHeader：将请求头信息和控制器方法的形参绑定
 *    5，CookieValue：将cookie数据和控制器方法的形参绑定
 *
 **/
@Controller
public class TestParamController {

    @RequestMapping(
            value = {"/param/servletAPI"},
            method = {RequestMethod.POST},
            params = {"username","password"}
            )
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:  "+username+"  password:  "+password);
        return "success";
    }

    @RequestMapping(
            value = {"/param"},
            method = {RequestMethod.POST},
            params = {"username","password"}
    )
    public String getParam(
            @RequestParam(
                    value = "username",  //别名
                    required = false,  //是否必须含有此值，默认为true
                    defaultValue = "默认的值") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jessionId){
        System.out.println("referer:  "+referer);
        System.out.println("JSESSIONID" + jessionId);
        System.out.println("username:  "+username+"  password:  "+password);
        return "success";
    }

    @RequestMapping(
            value = {"/param/pojo"},
            method = {RequestMethod.POST},
            params = {"id","username","password"}
    )
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

}















