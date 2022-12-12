package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /* 添加用户信息 */
    int insertUser();

    /* 修改用户信息 */
    int updateUser();

    /* 删除用户信息 */
    int deleteUser();

    /* 根据Id查询用户信息*/
    User getUserById();

    /* 查询所有用户信息*/
    List<User> getUserList();
}
