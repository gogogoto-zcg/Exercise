package com.exercise.web.controller;

import com.exercise.web.model.DemoModel;
import com.exercise.web.service.DemoService;
import com.sun.xml.internal.ws.client.sei.SEIStub;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Reference :
 * @Author : zcg
 * @Date : 2020/4/8 0008 - 11:15
 */
@Api("Demo")
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation("demo 接口测试mvc")
    @GetMapping("/demo")
    public DemoModel helloWorld(){
        DemoModel data = demoService.getData();
        return data;
    }

    /**
     * springmvc注解
     */
    @GetMapping("annotationTest/{id}")
    public void getByAnnotation(@PathVariable("id") Integer id,
                                @RequestParam("name")String name,
                                @CookieValue(value = "JSESSIONID",required = false)String sessionId,
                                @RequestHeader("User-Agent")String userAgent){
        System.out.println("【id】:"+id);
        System.out.println("【name】"+name);
        System.out.println("【sessionId】"+ sessionId);
        System.out.println("【userAgent】"+userAgent);
    }


}














