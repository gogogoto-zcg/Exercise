package com.exercise.web.mq.boot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -19:30
 * @Description : 生产者 -> 队列 -> 消费者
 */
@Component
public class SimpleListener {

    @RabbitListener(queuesToDeclare = @Queue(value = "spring.simple.queue"))
    public void simpleListen(String msg){
        System.out.println("消费者消费"+msg);
    }

}
