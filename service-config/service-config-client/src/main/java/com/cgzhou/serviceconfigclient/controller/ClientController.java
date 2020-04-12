package com.cgzhou.serviceconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/12 0012 23:48
 * @Description : TODO
 */
@RefreshScope
@RestController
public class ClientController {
    @Value("${word}")
    private String word;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return name+","+this.word;
    }
}
