package com.exercise.web.mapper;

import com.exercise.web.entity.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

    Department getDepartmentById(Integer id);

    /*测试延迟加载*/
    Department getDepartmentLazyById(Integer id);


}
