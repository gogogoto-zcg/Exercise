package com.cgzhou.serviceoms.service.impl;

import com.cgzhou.serviceoms.dto.ProductModel;
import com.cgzhou.serviceoms.feign.PmsFeign;
import com.cgzhou.serviceoms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/12 0012 15:45
 * @Description : TODO
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PmsFeign pmsFeign;

    @Override
    public Map<String, Object> getOrder(Long id) {

        Map<String, Object> map = new HashMap<>();
        //模拟数据库查询结果
        map.put("orderNo",id);
        map.put("userName","张三");
        //远程服务调用查询到商品
        ProductModel product = pmsFeign.getProduct(1L);
        map.put("product",product);
        return map;
    }
}
