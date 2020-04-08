package com.exercise.web.service.impl;

import com.exercise.web.entity.Employee;
import com.exercise.web.mapper.EmployeeMapper;
import com.exercise.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeesByDeptId(Integer id) {
        return employeeMapper.getEmployeesByDeptId(id);
    }
}
