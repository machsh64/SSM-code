package com.ren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-03 17:50
 * @description:
 *               访问的是用户资源，路径为 /user
 *               查询所有的用户信息 -->  /user-->get
 *               根据id查询用户信息 -->  /user/1-->get
 *               添加用户信息 -->  /user-->post
 *               修改用户信息 -->  /user-->put
 *               根据id删除用户信息 -->  /user/1-->delete
 *
 *            注意：浏览器目前只能发送get和post请求
 *            若要发送put和delete请求，需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
 *            配置了过滤器之后，发送的请求要满足两个条件，才能将请求方式转换为put或delete
 *             1，当前请求必须为post
 *             2，当前请求必须传输参数_method，_method的值才是最终的请求方式
 **/
@Controller()
public class TestRestController {

    @RequestMapping("/user")
    public String getAllUser() {
        System.out.println(" *    查询所有的用户信息 -->  /user-->get");
        return "success";
    }

    @RequestMapping("/user/{userId}")
    public String getUserById(@PathVariable("userId") Integer id) {
        System.out.println(" *    根据id查询用户信息 -->  /user/" + id + "-->get ");
        return "success";
    }

    @PostMapping("/user")
    public String insertUser(String username,String password){
        System.out.println(" *    添加用户信息 -->  /user-->post "+ username+" "+password);
        return "success";
    }

    @PutMapping("/user")
    public String updateUser(String username,String password){
        System.out.println(" *     修改用户信息 -->  /user-->put "+ username+" "+password);
        return "success";
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUserById(@PathVariable("userId") Integer id) {
        System.out.println(" *    根据id删除用户信息 -->  /user/" + id + "-->delete ");
        return "success";
    }
}
