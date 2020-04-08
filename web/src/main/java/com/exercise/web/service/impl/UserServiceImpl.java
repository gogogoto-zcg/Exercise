package com.exercise.web.service.impl;

import com.exercise.web.entity.User;
import com.exercise.web.mapper.UserMapper;
import com.exercise.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}
