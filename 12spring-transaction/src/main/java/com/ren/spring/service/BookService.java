package com.ren.spring.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 19:14
 * @description:
 **/
public interface BookService {

    /**
    * @Description: 买书的操作
    * @Param:
    * @Author: Ren
    * @return:
    * @Date: 2022/12/25 19:24
    */
    void buyBook(Integer userId, Integer bookId);
}
