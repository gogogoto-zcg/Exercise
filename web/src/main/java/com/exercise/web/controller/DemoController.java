package com.exercise.web.controller;

import com.exercise.web.model.DemoModel;
import com.exercise.web.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Reference :
 * @Author : zcg
 * @Date : 2020/4/8 0008 - 11:15
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo")
    public DemoModel helloWorld(){
        DemoModel data = demoService.getData();
        return data;
    }

}
