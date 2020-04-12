package com.cgzhou.serviceoms.feign;

import com.cgzhou.serviceoms.dto.ProductModel;
import com.cgzhou.serviceoms.exception.PmsFeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/12 0012 15:32
 * @Description : TODO
 */
@FeignClient(value = "SERVICE-PMS",fallback = PmsFeignException.class)
public interface PmsFeign {
    @GetMapping("/product/{id}")
    public ProductModel getProduct(@PathVariable("id") Long id);
}
