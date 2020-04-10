package com.exercise.web.mq.rabbitmqDemo.work;

import com.exercise.web.mq.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -17:33
 * @Description : 一个生产者多个消费者
 */
public class Recv2 {
    private static final String QUEUE_NAME="test_work_queue";

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //定义消费者同时只能处理一条消息
        channel.basicQos(1);
        //定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            //处理消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("【消费者2】received:"+msg);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,false,defaultConsumer);
    }
}
