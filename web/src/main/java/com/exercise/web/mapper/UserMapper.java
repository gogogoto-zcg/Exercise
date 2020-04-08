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

//    @Insert("insert into user('name','password') value( ${human.name}, ${human.password})")
    int addUser(@Param("human") User user);

    int deleteById(Integer id);

    int updateUser(@Param("user")User user);

    User getUserById(Integer id);
}
