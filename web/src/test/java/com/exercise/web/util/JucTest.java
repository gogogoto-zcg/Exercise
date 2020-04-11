package com.exercise.web.util;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/11 0011 -12:35
 * @Description :
 * 1、CountDownLatch
 * 2、CycleBarrier
 * 3、Semaphore
 * 4、ReentrantLock
 * 5、ThreadPool
 */
public class JucTest {

    //countDownLatch模拟  会议结束 ，五个人员都离开才能锁门
    //一个线程等待多个线程的通知，多个线程不阻塞
    @Test
    public void countDownLatch() throws InterruptedException {
        System.out.println("闭锁测试");
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("员工" + finalI + "离开会议室");
                latch.countDown();
                System.out.println("员工" + finalI + "继续做事");
            }).start();
        }
        latch.await();
        System.out.println("关闭会议室");
    }


    //王者荣耀抽奖积分 ，每抽积分到201 （这里假设五个积分） 就换一个王者水晶
    //多个线程等待突破屏障， 此时多个线程处于阻塞状态 (循环计数触发事件)
    public static Integer score = 0;

    @Test
    public void cycleBarrier() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("获得王者水晶");
            score = 0;
        });
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                score++;
                System.out.println("积分增加1，当前积分为" + score);
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                System.out.println(""); 屏障突破之后，当前线程继续执行
            }).start();
        }

        Thread.sleep(50000);
    }

    //抢车位，有车位有空就能停进去
    @Test
    public void semaphore() throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    //抢到车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "停入停车位");
                    Thread.sleep(1000);
                    //离开车位
                    System.out.println(Thread.currentThread().getName() + "离开停车位");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "人员【" + i + "】").start();
        }
        Thread.sleep(10000);
    }

    //ReentrantLock 可重入锁（可以继续调用执行需要当前锁的方法，无需重新获取）
    @Test
    public void reentrantLock() throws InterruptedException {
        MyThread myThread = new MyThread();
        new Thread(myThread,"线程1").start();
        new Thread(myThread,"线程2").start();
        Thread.sleep(5000);
    }

    //自定义线程池
    @Test
    public void threadPool() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.submit(()->{
                System.out.println(Thread.currentThread().getName()+":hello");
            });
        }

        Thread.sleep(10000);
    }

}

class MyThread implements Runnable{

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("执行业务");
            sleep();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void sleep(){
        lock.lock();
        try {
            System.out.println("别急，先睡两秒");
        } finally {
            lock.unlock();
        }

    }
}
