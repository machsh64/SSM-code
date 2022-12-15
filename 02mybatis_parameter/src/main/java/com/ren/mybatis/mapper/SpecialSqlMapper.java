package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-13 19:25
 * @description:
 **/
public interface SpecialSqlMapper {

    /**
    * @Description: 通过模糊查询用户
    * @Param: mohu
    * @Author: Ren
    * @return: List<User>
    * @Date: 2022/12/13 20:32
    */
    List<User> getUserByLike(@Param("mohu") String mohu);
    
   /**
   * @Description: 批量删除
   * @Param: ids
   * @Author: Ren
   * @return: Integer
   * @Date: 2022/12/13 20:31
   */
    Integer deleteMoreUser(@Param("ids") String ids);

    /**
    * @Description: 动态设置表名，查询用户信息
    * @Param: tableName
    * @Author: Ren
    * @return: List<User>
    * @Date: 2022/12/13 20:42
    */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
    * @Description: 添加用户信息，并自动获取主键
    * @Param: user
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/14 16:29
    */
    Integer insertUser(User user);
}
