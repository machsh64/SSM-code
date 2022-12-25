package com.ren.spring.dao.impl;

import com.ren.spring.dao.BookDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 19:16
 * @description:
 **/
@Repository
public class BookDaoImpl implements BookDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "SELECT price " +
                "FROM t_book " +
                "WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookId);
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql = "UPDATE t_book " +
                "SET stock = stock - 1 " +
                "WHERE book_id = ?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateBalance(Integer userId,Integer price) {
        String sql = "UPDATE t_user " +
                "SET balance = balance - ? " +
                "WHERE user_id = ?";
        jdbcTemplate.update(sql,price,userId);
    }
}
