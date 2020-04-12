package com.cgzhou.serviceoms.service;

import java.util.Map;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/12 0012 15:45
 * @Description : TODO
 */
public interface OrderService {

    /**
     * 查找订单
     * @param id
     * @return
     */
    Map<String,Object> getOrder(Long id);

}
