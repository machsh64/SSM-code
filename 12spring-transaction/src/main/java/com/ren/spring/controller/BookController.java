package com.ren.spring.controller;

import com.ren.spring.service.BookService;
import com.ren.spring.service.CheckoutService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 19:14
 * @description:
 **/
@Controller
public class BookController {

    @Resource
    private BookService bookService;
    @Resource
    private CheckoutService checkoutService;

    public BookController() {
    }


    public void byBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    public void checkout(Integer userId,Integer[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }
}
