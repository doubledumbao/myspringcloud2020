package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserDao;
import org.example.entity.User;
import org.example.util.MybatisUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    private SqlSession sqlSession;
    private UserDao mapper ;

    @Before
    public void before(){
        sqlSession = MybatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testQuery() {

        List<User> userList = mapper.getUserList();
        if (userList != null && userList.size() > 0) {
            for (User user : userList) {
                System.out.println(user);
            }
        }

    }

    @Test
    public void testGetUserById(){

        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void deleteUserById() {
        Integer integer = mapper.deleteUserById(3);
        System.out.println(integer);
        sqlSession.commit();
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsansan");
        user.setIdType("2");
        user.setIdNo("1234567");
        mapper.updateById(user);
        sqlSession.commit();
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setId(2);
        user.setIdType("1");
        user.setIdNo("123987");
        user.setName("lisi");
        Integer integer = mapper.insertUser(user);
        System.out.println(integer);
        sqlSession.commit();

    }



}
