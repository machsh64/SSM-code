package com.ren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-26 18:40
 * @description:
 *
 *     1，@RequestMapping注解标识的位置
 *       a > @RequestMapping 标识一个类：设置映射请求路径的初始信息
 *       b > @RequestMapping 标识一个方法：设置映射请求路径的具体信息
 *     2，@RequestMapping注解value属性
 *       作用：通过请求的请求路径匹配请求
 *         value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 *         则当前请求就会被注解所标识的方法进行处理
 *     3，@RequestMapping注解的method属性
 *       作用：通过请求方式匹配请求
 *         method属性是RequestMethod类型的数组，当前浏览器所发送的请求方式匹配method属性中的任何一个
 *         则当前请求就会被注解所标识的方法进行处理
 *         若浏览器发送的请求的请求路径和@RequestMapping注解value属性匹配，但是请求方式不匹配
 *         此时页面报错405 - Request method 'xxx' not supported
 *         在@RequestMapping的基础上，结合请求方法的一些派生注解：
 *         。@GetMapping，@PostMapping，@DeleteMapping，@PutMapping
 *     4，@RequestMapping注解的params属性
 *       作用：通过请求的请求参数匹配请求 ，即浏览器发送的请求的请求参数必须满足params属性的设置
 *         params 可以使用四种表达式：
 *         “param” ：表示当前所匹配请求的请求参数中必须携带param参数
 *         “!param” ：表示当前所匹配请求的请求参数中一定不能携带param参数
 *         “param = value” ：表示当前所匹配请求的请求参数中必须携带param参数且值必须为value
 *         “param != value” ：表示当前所匹配请求的请求参数中必须携带param参数且携带之一定不能是value
 *        若浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配，但是请求参数不匹配
 *        此时页面报错：400 - Parameter conditions "username" not met for actual request parameters;
 *     5，@RequestMapping注解的headers属性
 *       作用：通过请求的请求头信息匹配请求，即浏览器发送的请求头信息必须满足headers属性的设置
 *       若浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配，但是请求头信息不匹配
 *       此时页面报错：404 - Parameter conditions "username" not met for actual request parameters;
 *     6，SpringMVC支持ant风格的路径
 *       在@RequestMapping注解的value属性值设置一些特殊字符
 *        ? ：任意的单个字符（不包括 ? ）
 *        * ：任意个数的任意字符（不包括 ? 和 / ）
 *        ** ：任意层数的任意目录，注意使用方式只能 ** 写在双斜线中，前后不能有任何其他的字符
 *     7，@RequestMapping注解使用路径中的占位符
 *       传统： /deleteUser?id=1
 *       rest： /user/delete/1
 *       需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 *       在通过@PathVariable注解将占位符所表示的值和控制器方法的形参进行绑定
 **/
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    @RequestMapping(
            // 此时控制器方法所匹配的请求的请求路径为 /test/hello  或者 /test/abc  多个地址均可以匹配此位置
            value = {"/hello","/abc/{age}/{username}"},
            // 此时只有浏览器发送的请求方式为 POST 才会被匹配到
            method = {RequestMethod.POST}
            // 此时只有浏览器发送的请求 满足以下参数要求 才可以匹配方法
           // params = {"username","!password","age=20"}
            )
    public String hello(@PathVariable("age") Integer age, @PathVariable("username") String username){

        System.out.println("age: "+age+" username: "+username);
        return "success";
    }

}
