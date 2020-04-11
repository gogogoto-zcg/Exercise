package com.exercise.web.util;

import com.exercise.web.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/11 0011 -12:21
 * @Description : redis锁实现 以及ThreadLocal的基本使用
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class})
public class RedisLockTest {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //定义线程独有变量并初始化
    public static ThreadLocal<Integer> THREAD_lOCAL = new IntegerThreadLocal(); //重试次数
    public static class IntegerThreadLocal extends ThreadLocal<Integer> {
        @Override
        protected Integer initialValue() {
            return 2;
        }
    }

    public static String lockKey = "serviceLock"; //锁KEY
    @Test
    public void testRedisLock() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "running");
                Boolean lock = redisTemplate.opsForValue().setIfAbsent(lockKey, "1");
                if (lock) {
                    System.out.println("执行业务方法：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "释放锁");
                    redisTemplate.delete(lockKey);
                } else {
                    //等待1s，重试次数2
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (THREAD_lOCAL.get() > 0) {
                        THREAD_lOCAL.set(THREAD_lOCAL.get() - 1);
                        Thread.currentThread().run();
                    }
                }
            }, "Thread[" + i + "]").start();
        }

        //主线程等待
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
