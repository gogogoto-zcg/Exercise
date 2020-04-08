package com.exercise.web.service;

import com.exercise.web.WebApplication;
import com.exercise.web.entity.Department;
import com.exercise.web.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class})
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    void getDepartmentById() {
        System.out.println(departmentService.getDepartmentById(111));
    }

    @Test
    void getDepartmentLazyById(){
        Department department = departmentService.getDepartmentLazyById(111);
        System.out.println(department);
        System.out.println("======延迟加载属性======");
//        List<Employee> employeeList = department.getEmployeeList();
//        System.out.println(employeeList);
    }
}