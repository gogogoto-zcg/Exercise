package com.cgzhou.serivcepms.controller;

import com.cgzhou.serivcepms.dto.ProductModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pms")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/product/{id}")
    public ProductModel getProduct(@PathVariable("id") Long id){
        ProductModel productModel = new ProductModel();
        productModel.setSkuId(id);
        productModel.setSkuName("华为手机");
        productModel.setSkuDesc("像素高 ---来自服务："+port);
        return productModel;
    }
}
