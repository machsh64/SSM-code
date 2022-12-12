package com.ren.mybatis.mapper;

import com.ren.mybatis.pojo.User;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-10 21:09
 * @description: Mybatis获取参数值的两种方式：
 *                   #{} 相当于sql中的填充占位符 ? ，${} 相当于字符串拼接
 *                 1，若mapper接口方法的参数为单个的字面量类型
 *                    此时可以通过 #{} 和 ${} 以任意的内容获取参数值，一定要注意${} 的单引号问题
 *                 2，若mapper接口方法的参数为多个的字面量类型
 *                    此时mybatis会将参数放在map集合中，以两种方式存储数据
 *                    a > 以arg0,arg1...为键，以参数为值
 *                    b > 以param1,param2...为键，以参数为值
 *                    因此，只需要通过#{} 和 ${} 访问map集合的键，就可以获取对应的值
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
    User checkLogin(String username,String password);
}
