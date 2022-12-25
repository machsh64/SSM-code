package com.ren.spring.service;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 21:05
 * @description:
 **/
public interface CheckoutService {

    /**
    * @Description: 买多本书的操作
    * @Param:  userId，bookIds
    * @Author: Ren
    * @return:
    * @Date: 2022/12/25 21:08
    */
    void checkout(Integer userId,Integer[] bookIds);
}
