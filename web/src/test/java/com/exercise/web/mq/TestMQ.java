package com.exercise.web.mq;

import com.exercise.web.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -19:18
 * @Description : TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class})
public class TestMQ {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //生产者 -》队列 -》消费者
    @Test
    public void testSimpleListener() throws InterruptedException {
        String msg = "RabbitMQ simple ...";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("spring.simple.queue", msg + i);
        }
        Thread.sleep(5000);
    }

    //生产者-》队列-》 多个消费者
    @Test
    public void testWorkListener() throws InterruptedException {
        String msg = "RabbitMQ work ...";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("spring.work.queue", msg + i);
        }
        Thread.sleep(5000);
    }

    // 生产者只负责发送消息到交换机 ，队列与交换机绑定
    @Test
    public void fanout() throws InterruptedException {
        String msg = "RabbitMQ fanout ...";
        for (int i = 0; i < 10; i++) {
            // 这里注意细节，第二个参数需要写，不然第一个参数就变成routingKey了
            amqpTemplate.convertAndSend("spring.fanout.exchange", "", msg + i);
        }
        Thread.sleep(5000);
    }

    @Test
    public void direct() throws InterruptedException {
        String msg = "RabbitMQ direct ...";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("spring.direct.exchange", "direct", msg + i);
        }
        Thread.sleep(5000);
    }

    //topic
    @Test
    public void testTopicListener() throws InterruptedException {
        String msg = "hello, Spring boot amqp";
        this.amqpTemplate.convertAndSend("spring.test.exchange","a.b", msg);
        // 等待10秒后再结束
        Thread.sleep(10000);
    }
}
