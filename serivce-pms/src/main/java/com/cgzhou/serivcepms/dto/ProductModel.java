package com.cgzhou.serivcepms.dto;

import lombok.Data;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/12 0012 15:19
 * @Description : 商品传输模型
 */
@Data
public class ProductModel {
    private Long skuId;
    private String skuName;
    private String skuDesc;
}

