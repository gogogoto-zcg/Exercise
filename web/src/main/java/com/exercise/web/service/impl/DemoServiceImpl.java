package com.exercise.web.service.impl;

import com.exercise.web.annotation.MyAnnotation;
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

    @MyAnnotation(value = "value",prefix = "prefix")
    @Override
    public DemoModel getData() {
//        int i=10/0;  //测试异常通知

        //返回一个Map对象
        Map<String, String> map = new HashMap<String,String>();
        map.put("key","value");
        DemoModel demoModel = new DemoModel(true,"操作成功",map);
        return demoModel;
    }
}
