package com.ren.spring.service.impl;

import com.ren.spring.dao.BookDao;
import com.ren.spring.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 19:15
 * @description:
 **/
@Service
public class BookServiceImpl implements BookService {

    @Resource()
    private BookDao bookDao;

    @Override
    @Transactional(
            //readOnly = true  //设置是否只读的属性  一般在只查询的方法中使用
            //timeout = 3   //设置超时回滚的时间
            //noRollbackFor = ArithmeticException.class  //根据异常类型排除回滚
            //noRollbackForClassName = "java.lang.ArithmeticException"   //根据异常路径排除回滚
            //isolation = Isolation.DEFAULT  //事务的隔离级别  默认为可重复读  属性有 读未提交  读已提交  可重复读  串行化
            propagation = Propagation.REQUIRES_NEW
    )
    public void buyBook(Integer userId, Integer bookId) {
      /*  try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();`
        }*/
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
