package com.exercise.web.service.impl;

import com.exercise.web.model.DemoModel;
import com.exercise.web.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Reference :
 * @Author : zcg
 * @Date : 2020/4/8 0008 - 11:23
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public DemoModel getData() {
        //返回一个Map对象
        Map<String, String> map = new HashMap<String,String>();
        map.put("key","value");
        DemoModel demoModel = new DemoModel(true,"操作成功",map);
        return demoModel;
    }
}
