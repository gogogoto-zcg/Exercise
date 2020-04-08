package com.exercise.web.service;

import com.exercise.web.WebApplication;
import com.exercise.web.entity.User;
import com.exercise.web.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class})
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void findAll() {
        List<User> users = userService.findAll();
        users.forEach(System.out::print);
    }


    @Test
    void addUser(){
        User user = new User();
        user.setId(null);
        user.setName("zcg");
        user.setPassword("123456");
        System.out.println(userService.addUser(user));
    }

    @Test
    void deleteUserById(){
        System.out.println(userService.deleteById(5));
    }

    @Test
    void updateUser(){
        User user = new User();
        user.setId(6L);
        user.setName("zcg");
        user.setPassword("123456");
        System.out.println(userService.updateUser(user));
    }

    @Test
    void getUserById(){
        System.out.println(userService.getUserById(6));
    }

}