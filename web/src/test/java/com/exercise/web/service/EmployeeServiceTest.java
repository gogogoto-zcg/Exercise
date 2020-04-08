package com.exercise.web.service;

import com.exercise.web.WebApplication;
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
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getEmployeesByDeptId() {
        List<Employee> employeeList = employeeService.getEmployeesByDeptId(111);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}