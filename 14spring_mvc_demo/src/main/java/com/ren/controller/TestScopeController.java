package com.ren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-27 19:08
 * @description:
 *
 *   向域对象共享数据：
 *   1，通过ModelAndView向请求域共享数据
 *     使用ModelAndView时，可以使用其Model功能向请求域共享数据
 *     使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 *   2，使用Model向请求域共享数据
 *   3，使用ModelMap向请求域共享数据
 *   4，使用map向请求域共享数据
 *   5，Model和ModelMap和map的关系
 *      其实在底层中，这些类型的形参最终都是通过BindingAwareModelMap创建
 *        public class BindingAwareModelMap Extends ExtendedModelMap { }
 *        public class ExtendedModel Extends ModelMap implements Model { }
 *        public class ModelMap Extends LinkedHashMap<String. Object> { }
 **/
@Controller
public class TestScopeController {

    @RequestMapping(
            value = {"/test/mav"}
    )
    public ModelAndView testMAV(){
        /**
        * ModelAndView博阿寒Model和View的功能
         *  Model ：向请求域中共享数据
         *  View  ：设置逻辑视图实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModel(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testModel(Map<String, Object> map){
        map.put("testRequestScope","hello,map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testRequestScope","hello,session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testRequestScope","hello,application");
        return "success";
    }
}
