package com.ren.spring.test;

import com.ren.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-21 17:34
 * @description:
 **/
public class AutowireByXmlTest {

    /**
    * 自动装配：
     * 根据指定的策略，在IOC容器中匹配某个bean，根据自动bean中的类类型的属性或接口类型的属性赋值
     * 可以通过bean策略中的autowire属性设置自动装配的策略
     * 自动装配的策略：
     * 1，no，default：表示不装配，即bean中的属性不会自动去匹配某个bean为属性赋值，此时属性使用默认值
     * 2，byType：根据要赋值的属性的类型，在IOC容器中匹配某个bean，为属性赋值
     *      ！注！：
     *        a > 若通过类型没有找到任何一个类型匹配的bean，此时不装配，属性使用默认值，不会报错受检异常，但会报运行时异常空指针异常
     *        b > 若通过类型找到了多个类型匹配的bean，会抛出异常：NoUniqueBeanDefinitionException(未指定bean异常) 若IOC容器中有多个同class不同id的bean，此时若使用byType，则直接会报受检异常
     *      总结：当使用byType实现自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性赋值
     *
     * 3，byName：将要赋值的属性的属性名作为bean的id在IOC容器中匹配某个bean，为属性赋值
     *      总结：当类型匹配的bean有多个时，此时可以使用byName实现自动装配
    */

    @Test
    public void testAutowire() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = applicationContext.getBean("user",UserController.class);
        userController.saveUser();
    }
}
