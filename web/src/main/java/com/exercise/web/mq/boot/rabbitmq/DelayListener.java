package com.exercise.web.mq.boot.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.exercise.web.config.RabbitMqConfig.DELAY_QUEUE;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -23:59
 * @Description :
 *  死信队列的三种情况
 *  消息被拒绝。通过调用basic.reject或者basic.nack并且设置的requeue参数为false。
 *  消息因为设置了TTL而过期。
 *  消息进入了一条已经达到最大长度的队列。
 */
@Component
public class DelayListener {

    @RabbitListener(queues=DELAY_QUEUE)
    public void delayListener(String msg, Channel channel , Message message) throws IOException {
        try {
            System.out.println("接收到延迟队列的信息:"+msg);
            int i = 10/0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            System.out.println("异常："+e.getMessage());
            //消息重新入队
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }
}
