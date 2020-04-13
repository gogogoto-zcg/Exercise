package com.exercise.web.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/13 0013 19:02
 * @Description : TODO
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("beanLife")) {
            System.out.println("【第五步】：初始化之前执行的方法");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("beanLife")){
            System.out.println("【第八步】：初始化之后执行的方法");
        }
        return bean;
    }
}
