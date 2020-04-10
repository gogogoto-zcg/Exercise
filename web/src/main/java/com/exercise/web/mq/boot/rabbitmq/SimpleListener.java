package com.exercise.web.mq.boot.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -19:30
 * @Description : 生产者 -> 队列 -> 消费者
 */
@Component
public class SimpleListener {

    @RabbitListener(queuesToDeclare = @Queue(value = "spring.simple.queue"))
    public void simpleListen(String msg, Channel channel, Message message) throws IOException {
        try {
            System.out.println("消费者消费"+msg);
            int i= 10/0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            System.out.println("【消息重新入队】业务异常:"+e.getMessage());
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }

    }

}
