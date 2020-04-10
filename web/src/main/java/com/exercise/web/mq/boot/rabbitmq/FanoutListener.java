package com.exercise.web.mq.boot.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -21:23
 * @Description : TODO
 */
@Component
public class FanoutListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.fanout.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.fanout.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen(String msg) {
        System.out.println("FanoutListener listen 接收到消息：" + msg);
    }

    // 队列2（第二个人），同样能接收到消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.fanout2.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.fanout.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen2(String msg) {
        System.out.println("FanoutListener listen2 接收到消息：" + msg);
    }

}
