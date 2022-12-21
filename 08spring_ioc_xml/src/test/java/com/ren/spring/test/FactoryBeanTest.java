package com.ren.spring.test;

import com.ren.spring.factory.UserFactoryBean;
import com.ren.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-21 17:11
 * @description:
 **/
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-factory.xml");
        UserFactoryBean userFactoryBean = applicationContext.getBean(UserFactoryBean.class);
        User user = userFactoryBean.getObject();
        System.out.println(user);
    }
}
