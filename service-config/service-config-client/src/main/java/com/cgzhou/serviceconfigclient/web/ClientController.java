package com.cgzhou.serviceconfigclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/13 0013 2:08
 * @Description : 配置中心的客户端
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

