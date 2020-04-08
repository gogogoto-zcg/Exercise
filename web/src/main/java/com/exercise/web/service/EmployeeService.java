package com.exercise.web.service;

import com.exercise.web.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeesByDeptId(Integer id);
}
