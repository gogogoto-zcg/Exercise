package com.exercise.web.service;

import com.exercise.web.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    int addUser(User user);

    int deleteById(Integer id);

    int updateUser(User user);

    User getUserById(Integer id);

}
