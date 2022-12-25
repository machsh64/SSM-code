package com.ren.spring.test;

import com.ren.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: SSM
 * @author: Ren  https://github.com/machsh64
 * @create: 2022-12-25 18:17
 * @description:
 **/
// 指定当前测试类在Spring的测试环境中执行，此时可以通过注入的方式，直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "INSERT INTO t_user(username,password,age,gender,email) " +
                "VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,"root","password",13,"男","root@gmail.com");     //可以实现增删改
    }

    @Test
    public void testQueryUserById() {
        String sql = "SELECT * " +
                "FROM t_user " +
                "WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void testQueryAllUser() {
        String sql = "SELECT * " +
                "FROM t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        userList.forEach(System.out::println);
    }

    @Test
    public void testQueryCount() {
        String sql = "SELECT count(*) " +
                "FROM t_user";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }
}
