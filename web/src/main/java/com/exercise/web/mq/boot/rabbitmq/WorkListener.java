package com.exercise.web.mq.boot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -19:37
 * @Description : 生产者-》队列-》多个消费者
 */
@Component
public class WorkListener {
    // 通过注解自动创建 spring.work.queue 队列
    @RabbitListener(queuesToDeclare = @Queue("spring.work.queue"))
    public void listen(String msg) {
        System.out.println("WorkListener listen 接收到消息：" + msg);
    }

    // 创建两个队列共同消费
    @RabbitListener(queuesToDeclare = @Queue("spring.work.queue"))
    public void listen2(String msg) throws InterruptedException {
        System.out.println("WorkListener listen2 接收到消息：" + msg);
        Thread.sleep(100);
    }
}
