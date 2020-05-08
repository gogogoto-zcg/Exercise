package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : cg.Zhou
 * @date : 2020/5/7 0007 14:50
 * @Description : 测试Nginx负载均衡
 */
@RestController
public class DemoController {
    @Value("${server.port}")
    String port;

    @GetMapping("demo")
    public Object hello(){
        return "端口号："+port;
    }
}
