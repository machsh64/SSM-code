package com.ren.spring.dao;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 19:15
 * @description:
 **/
public interface BookDao {

    /**
    * @Description: 查询图书的价格
    * @Param: bookId
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/25 19:27
    */
    Integer getPriceByBookId(Integer bookId);

    /**
    * @Description: 更新图书的库存
    * @Param: bookId
    * @Author: Ren
    * @return:
    * @Date: 2022/12/25 19:29
    */
    void updateStock(Integer bookId);

    /**
    * @Description: 更新用户的余额
    * @Param: userId
    * @Author: Ren
    * @return:
    * @Date: 2022/12/25 19:30
    */
    void updateBalance(Integer userId,Integer price);
}
