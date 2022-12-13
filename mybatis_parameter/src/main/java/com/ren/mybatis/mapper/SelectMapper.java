package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-13 18:00
 * @description:
 *    若sql语句查询的结果为多条时，一定不能以实体类类型作为方法的返回值
 *    否则会抛出异常TooManyResultsException
 *    若sql语句查询的结果为一条时，此时可以使用实体类类型List集合作为方法的返回值
 **/
public interface SelectMapper {

    /**
    * @Param: 查询用户 By Id
    * @Author: Ren
    * @return: User
    * @Date: 2022/12/13 18:06
    */
    User getUserById(@Param("id") Integer id);

    /**
    * @Param: 查询所有用户的功能
    * @Author: Ren
    * @return: List<User>
    * @Date: 2022/12/13 18:06
    */
    List<User> getAllUser();

    /**
    * @Param: 查询用户的总数量 单行单列的数据
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/13 18:20
    */
    Integer getCount();

    /**
    * @Param: 通过Id获取用户，利用集合获取
    * @Author: Ren
    * @return: Map<String,Object>
    * @Date: 2022/12/13 18:39
    */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
    * @Param: 查询所有的用户信息，利用map结合获取
     * 若查询的数据有多条时，并且要将每条数据转换为map集合
     * 此时有两种解决方案：
     * 1，将mapper接口方法的返回值设置为泛型是map的list集合
     * List<Map<String,Object>> getAllUserToMap()
     * 2，可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MaoKey注解
     * 将查询的某个字段的值作为大的map的键
     * @MapKey("id")
     * Map<Object, Object> getAllUserToMap();
    * @Author: Ren
    * @return: Mao<String,Object>
    * @Date: 2022/12/13 18:51
    */
    // List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<Object,Object> getAllUserToMap();

}
