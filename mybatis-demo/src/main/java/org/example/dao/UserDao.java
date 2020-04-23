package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    User getUserById(Integer id);

    Integer deleteUserById(Integer id);

    Integer updateById(User user);

    Integer insertUser(User user);
}
