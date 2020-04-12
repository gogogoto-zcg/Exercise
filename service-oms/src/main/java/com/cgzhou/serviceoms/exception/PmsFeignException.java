package com.cgzhou.serviceoms.exception;

import com.cgzhou.serviceoms.dto.ProductModel;
import com.cgzhou.serviceoms.feign.PmsFeign;
import org.springframework.stereotype.Component;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/12 0012 16:10
 * @Description : TODO
 */
@Component
public class PmsFeignException implements PmsFeign {
    @Override
    public ProductModel getProduct(Long id) {
        ProductModel model = new ProductModel();
        model.setSkuId(id);
        model.setSkuName("无此产品");
        model.setSkuDesc("无此产品");
        return model;
    }
}
