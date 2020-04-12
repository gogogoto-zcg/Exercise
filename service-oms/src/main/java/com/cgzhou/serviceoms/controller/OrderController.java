package com.cgzhou.serviceoms.controller;

import com.cgzhou.serviceoms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/12 0012 15:28
 * @Description : TODO
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order/{id}")
    public Map getOrder(@PathVariable("id") Long id){
        return orderService.getOrder(id);
    }
}
