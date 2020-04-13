package com.exercise.web.util;

import com.exercise.web.WebApplication;
import com.exercise.web.entity.BeanLife;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/13 0013 19:05
 * @Description : TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class})
public class BeanLifeTest {

    @Autowired
    BeanLife beanLife;

    @Test
    public void testBeanLife(){

        System.out.println("意思意思"+beanLife.getName());
    }
}
