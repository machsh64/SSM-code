package com.ren.spring.service.impl;

import com.ren.spring.service.BookService;
import com.ren.spring.service.CheckoutService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 21:05
 * @description:
 **/
@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Resource
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds){
            bookService.buyBook(userId,bookId);
        }
    }
}
