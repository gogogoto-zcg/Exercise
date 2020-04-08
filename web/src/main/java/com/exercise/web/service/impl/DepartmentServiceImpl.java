package com.exercise.web.service.impl;

import com.exercise.web.entity.Department;
import com.exercise.web.mapper.DepartmentMapper;
import com.exercise.web.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public Department getDepartmentLazyById(Integer id) {
        return departmentMapper.getDepartmentLazyById(id);
    }
}
