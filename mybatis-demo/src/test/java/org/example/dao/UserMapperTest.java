package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.util.MybatisUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    private SqlSession sqlSession;
    private MyUserMapper mapper ;

    @Before
    public void before(){
        sqlSession = MybatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(MyUserMapper.class);
    }

    @Test
    public void getUserList() {
        List<MyUser> userList = mapper.getUserList();
        for (MyUser user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void updateById() {
    }

    @Test
    public void insertUser() {
    }

    @After
    public void after(){
        sqlSession.close();
    }
}