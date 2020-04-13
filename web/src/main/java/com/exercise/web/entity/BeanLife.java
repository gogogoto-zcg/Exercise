package com.exercise.web.entity;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/13 0013 18:38
 * @Description : bean 生命周期测试
 * 实例化-》属性注入-》前置处理器-》初始化（属性注入之后afterProperties）-》后置处理器-》个人业务使用-》销毁
 */
@Data
@Component
public class BeanLife implements BeanNameAware, ApplicationContextAware, InitializingBean , DisposableBean {
   @Value("${beanLife.name}")
   private String name;

   public BeanLife(){
      System.out.println("【第一步】：实例化类");
   }

   public void setName(String name){
      System.out.println("【第二步】：设置属性");
      this.name=name;
   }


   @Override
   public void setBeanName(String name) {
      System.out.println("【第三步】此时bean的name:"+this.name);
      System.out.println("【第三步】：设置bean的名称也就是spring容器中的名称，也就是id"+name);
   }

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      System.out.println("【第四步】：了解工厂信息"+applicationContext);
   }

   //第五步执行初始化之前执行的方法

   @Override
   public void afterPropertiesSet() throws Exception {
      System.out.println("【第六步】：属性设置之后执行的方法----name:"+name);
   }

   public void setup(){
      System.out.println("【第七步】：执行自己配置的初始化方法");
   }

   //第八步执行初始化之后的方法

   public void run(){
      System.out.println("【第九步】：执行自身业务方法");
   }


   @Override
   public void destroy() throws Exception {
      System.out.println("【第十步】：执行spring的销毁方法");
   }

   public void destroy1(){
      System.out.println("【第十一步】：执行自己配置的销毁方法");
   }
}

