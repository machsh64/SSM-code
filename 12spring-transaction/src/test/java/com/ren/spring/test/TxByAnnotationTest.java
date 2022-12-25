package com.ren.spring.test;

import com.ren.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 19:39
 * @description:
 *
 *    声明式事务管理的配置步骤
 *    1，在spring的配置文件中配置事务管理器  bean(id="transactionManager",class="DataSourceTransactionManager"<property id="dataSource",ref="druidDataSource"
 *    2，开启事务的注解驱动 tx:annotation-driver(transaction-manager="transactionManager"
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {

    @Resource
    private BookController bookController;

    @Test
    public void testBuyBook() {
        //bookController.byBook(1,1);
        bookController.checkout(1,new Integer[]{1,2});
    }
}

