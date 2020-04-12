package com.cgzhou.serviceconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigClientApplication.class, args);
        System.out.println("配置中心客户端启动成功!");
    }

}
