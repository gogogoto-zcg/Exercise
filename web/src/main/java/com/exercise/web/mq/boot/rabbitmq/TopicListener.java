package com.exercise.web.mq.boot.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -19:08
 * @Description : springboot 整合rabbitmq  监听器（消费者）实现
 */
@Component
public class TopicListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.test.queue",durable = "true"),
            exchange = @Exchange(
                    value = "spring.test.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC,
                    durable = "true"
            ),
            key = "a.*"
    ))
    public void listen(String msg){
        System.out.println("接收到消息"+msg);
    }
}
