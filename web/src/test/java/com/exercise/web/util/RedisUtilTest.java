package com.exercise.web.util;

import com.exercise.web.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/9 0009 -22:50
 * @Description : redis工具类测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class})
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testString(){
        redisUtil.set("strKey","value");
    }

}