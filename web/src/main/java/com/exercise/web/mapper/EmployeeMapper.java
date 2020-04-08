package com.exercise.web.mapper;

import com.exercise.web.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> getEmployeesByDeptId(Integer id);

    /*测试延迟加载*/
    List<Employee> findEmployeeById(Integer id);
}
