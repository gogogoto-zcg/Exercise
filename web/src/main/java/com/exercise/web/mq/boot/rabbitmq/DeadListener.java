package com.exercise.web.mq.boot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.exercise.web.config.RabbitMqConfig.DEAD_QUEUE;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/11 0011 -01:50
 * @Description : TODO
 */
@Component
public class DeadListener {

    @RabbitListener(queues= DEAD_QUEUE)
    public void deadListener(String msg){
        System.out.println("处理死信队列的消息。。。。："+msg);
    }
}
