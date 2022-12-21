package com.ren.spring.test;

import com.ren.spring.controller.UserController;
import com.ren.spring.dao.UserDao;
import com.ren.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-21 19:27
 * @description:
 **/
public class IOCByAnnotationTest {

    /**
    *标识组件的常用注解
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件
     *
     * 通过注解＋扫描所配置的bean的id，默认值为类的小驼峰，即类名的首字母为小写的结果
     *
     * @Autowired ：实现自动装配功能的注解
     *   1，@Autowired注解能够标识的位置
     *    a > 标识在成员变量上，此时不需要设置成员变量的set方法
     *    b > 标识在set方法上
     *    c > 为当前成员变量赋值的有参构造上
     *
     *   2，@Autowired注解的原理
     *    a > 默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     *    b > 若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
     *        即将要赋值的属性的属性名做为bean的id匹配某个bean为属性赋值
     *    c > 若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean，
     *        且这些bean的id和要赋值的属性的属性名不一致，此时抛异常：NoUniqueBeanDefinitionException
     *    d > 此时可以在要赋值的属性上，添加一个注解@Qualifier
     *        通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
     *
     * @Resource ：实现自动装配功能的注解
     *   1，@Resource注解能够标识的位置
     *    a > 标识在成员变量上，此时不需要设置成员变量的set方法
     *    b > 标识在set方法上
     *   2，@Resource注解的原理
     *    a > 默认通过byName的方式，在IOC容器中通过id匹配某个bean为属性赋值
     *     @Resource 装配顺序
     * 　 a. 如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
     * 　 b. 如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
     * 　 c. 如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
     * 　 d. 如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配；
     *
    */

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = applicationContext.getBean("user",UserController.class);     //此处在UserController的注解@Controller("user")中设置了默认id
        System.out.println(userController);
        UserService userService = applicationContext.getBean("userServiceImpl",UserService.class);
        System.out.println(userService);
        UserDao userDao = applicationContext.getBean("userDaoImpl",UserDao.class);
        System.out.println(userDao);

        userController.saveUser();
    }
}
