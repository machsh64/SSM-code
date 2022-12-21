package com.ren.spring.test;

import com.ren.spring.pojo.Clazz;
import com.ren.spring.pojo.Student;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-18 17:37
 * @description:
 **/
public class StudentTest {

    /**
    *  获取bean的三种方法
     *  1，根据bean的id获取
     *  2，根据bean的类型获取
     *  注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     *   若没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
     *   若有多个类型相匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
     *  3，根据bean的id和类型获取
    */

    @Test
    public void testIOC() {
        //获取IOC容器
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        /*Student studentOne = (Student) application.getBean("studentOne");*/
        //Student studentOne = application.getBean(Student.class);
        //Student studentOne = application.getBean("studentOne", Student.class);
        Student studentTwo = application.getBean("studentTwo", Student.class);
        System.out.println(studentTwo);
        Student studentThr = application.getBean("studentThr", Student.class);
        System.out.println(studentThr);

    }

    @Test
    public void testStudentFour() {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentFour = application.getBean("studentFour", Student.class);
        System.out.println(studentFour);
        Student studentFive = application.getBean("studentFive", Student.class);
        System.out.println(studentFive);
        Student studentSix = application.getBean("studentSix", Student.class);
        System.out.println(studentSix);
        Student studentSeven = application.getBean("studentSeven", Student.class);
        System.out.println(studentSeven);
    }

    @Test
    public void testClazzTest() {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazzTwo = application.getBean("clazzTwo", Clazz.class);
        System.out.println(clazzTwo);
    }

    @Test
    public void testStudentEight() {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentEight = application.getBean("studentEight", Student.class);
        System.out.println(studentEight);
        Student studentNine = application.getBean("studentNine", Student.class);
        System.out.println(studentNine);
    }

    @Test
    public void testStudentTen() {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentTen = application.getBean("studentTen", Student.class);
        System.out.println(studentTen);
    }
}
