package com.exercise.web.service;

import com.exercise.web.WebApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}