package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-10 21:09
 * @description: Mybatis获取参数值的两种方式：
 *                 #{} 相当于sql中的填充占位符 ? ，${} 相当于字符串拼接
 *                 1，若mapper接口方法的参数为单个的字面量类型
 *                   此时可以通过 #{} 和 ${} 以任意的内容获取参数值，一定要注意${} 的单引号问题
 *                 2，若mapper接口方法的参数为多个的字面量类型
 *                   此时mybatis会将参数放在map集合中，以两种方式存储数据
 *                   a > 以arg0,arg1...为键，以参数为值
 *                   b > 以param1,param2...为键，以参数为值
 *                   因此，只需要通过#{} 和 ${} 访问map集合的键，就可以获取对应的值
 *                 3，若mapper接口方法的参数为map集合类型的参数，只需要通过#{} 和 ${} 访问map集合的键，就可以获取对应的值
 *                 4，若mapper接口方法的参数为实体类类型的参数，只需要通过#{} 和 ${} 访问map集合的键，就可以获取对应的值
 *                 5，可以在mapper接口方法的参数上设置@Param注解，此时MyBatis会将这些参数放在map中，以两种方式进行存储
 *                   a > 以@Param注解的value属性为键，以参数为值
 *                   b > 以param1，param2...为键，以参数为值
 *                   只需要通过#{} 和 ${} 访问map集合的键，就可以获取对应的值，一定要注意${} 的单引号问题
 *
 **/
public interface UserMapper {

    /**
     * @Param: 根据用户名查询用户信息
     * @Author: Ren
     * @return: User
     * @Date: 2022/12/12 18:29
     */
    User getUserByUserName(String username);

    /**
     * @Param: 验证登录
     * @Author: Ren
     * @return: User
     * @Date: 2022/12/12 18:52
     */
    User checkLogin(String username, String password);

    /**
     * @Param: 测试登录，使用Map传参
     * @Author: Ren
     * @return: user
     * @Date: 2022/12/13 16:55
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
    * @Param: 添加实体类对象
    * @Author: Ren
    * @return: Integer
    * @Date: 2022/12/13 17:20
    */
    Integer insertUser(User user);

    /**
    * @Param: 验证登录 使用注解(@Param)进行传参
    * @Author: Ren
    * @return:  User
    * @Date: 2022/12/13 17:36
    */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
