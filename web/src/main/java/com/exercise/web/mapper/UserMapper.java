package com.exercise.web.mapper;

import com.exercise.web.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    int addUser(User user);

    int deleteById(Integer id);

    int updateUser(User user);

    User getUserById(Integer id);
}
