package com.ren.mybatis.test;

import com.ren.mybatis.mapper.SelectMapper;
import com.ren.mybatis.pojo.User;
import com.ren.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: SSM
 * @author: Ren
 * @create: 2022-12-13 18:01
 * @description:
 **/
public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(9);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println("总行数为："+count);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userMap = mapper.getUserByIdToMap(9);
        System.out.println(userMap);  //  {password=123456, gender=男, id=9, age=22, email=testtest@gmail.com, username=testInsert}
        Set<Map.Entry<String, Object>> entrySet = userMap.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            System.out.println("key: " + key +"  ---> value: "+value);
        }
        sqlSession.close();
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        // allUserToMap.forEach(System.out::println);
        Map<Object, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
        //  {2={password=123, gender=男, id=2, age=12, email=123@gmail.com, username=root},
        //  5={password=123456, gender=男, id=5, age=23, email=12345@gmail.com, username=admin},
        //  7={password=123456, gender=男, id=7, age=23, email=12345@gmail.com, username=admin},
        //  8={password=123456, gender=男, id=8, age=23, email=12345@gmail.com, username=admin},
        // 9={password=123456, gender=男, id=9, age=22, email=testtest@gmail.com, username=testInsert}}
        Set<Map.Entry<Object, Object>> entrySet = allUserToMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            Object key = next.getKey();
            Object value = next.getValue();
            System.out.println("key: " + key +"  ---> value: "+value);
        }
  /*      for (Map<String,Object> userMap : allUserToMap) {
            Set<Map.Entry<String, Object>> entrySet = userMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                System.out.println("key: " + key +"  ---> value: "+value);
            }
            System.out.println("****************************");
        }*/
        sqlSession.close();
    }
}
