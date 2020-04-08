package com.exercise.web.service;

import com.exercise.web.entity.Department;

public interface DepartmentService {

    Department getDepartmentById(Integer id);

    Department getDepartmentLazyById(Integer id);

}
