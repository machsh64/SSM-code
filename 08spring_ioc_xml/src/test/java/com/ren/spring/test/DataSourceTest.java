package com.ren.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-20 18:24
 * @description:
 **/
public class DataSourceTest {

    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = applicationContext.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
