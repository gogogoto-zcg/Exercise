package com.exercise.web.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/10 0010 -23:04
 * @Description : 实现延迟队列
 */
@EnableRabbit
@Configuration
public class RabbitMqConfig {

    //延迟交换机
    public static final String DELAY_EXCHANGE = "DELAY_EXCHANGE";
    //死信交换机
    public static final String DEAD_EXCHANGE = "DEAD_EXCHANGE";
    //延迟队列
    public static final String DELAY_QUEUE = "DELAY_QUEUE";
    //私信队列
    public static final String DEAD_QUEUE = "DEAD_QUEUE";

    //延迟交换机
    @Bean(DELAY_EXCHANGE)
    public Exchange delayExchange() {
        return new TopicExchange(DELAY_EXCHANGE, true, false, null);
    }

    //死信交换机
    @Bean(DEAD_EXCHANGE)
    public Exchange deadExchange(){
        return new TopicExchange(DEAD_EXCHANGE,true,false,null);
    }

    //声明一个延迟队列
    @Bean(DELAY_QUEUE)
    public Queue delayQueue() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", DEAD_EXCHANGE);  //消息过期之后发送的交换机
        arguments.put("x-dead-letter-routing-key", "msg.dead");  //信息过期之后指定路由键发送消息
        arguments.put("x-message-ttl", 120000); //延迟时间
        return new Queue(DELAY_QUEUE, true, false, false, arguments);
    }

    //延迟队列绑定交换机
    @Bean("delayBinding")
    public Binding delayBindQueue(@Qualifier(DELAY_QUEUE)Queue delayQueue,@Qualifier(DELAY_EXCHANGE) Exchange delayExchange){
//        return new Binding(DEAD_QUEUE, Binding.DestinationType.QUEUE,DELAY_EXCHANGE,"mes.close",null); //无效
        return BindingBuilder.bind(delayQueue).to(delayExchange).with("msg.delay").noargs();
    }

    //声明一个死信队列
    @Bean(DEAD_QUEUE)
    public Queue deadQueue(){
        return new Queue(DEAD_QUEUE,true,false,false,null);
    }

    //死信队列绑定交换机
    @Bean("deadBinding")
    public Binding deadBinding(@Qualifier(DEAD_QUEUE) Queue deadQueue ,@Qualifier(DEAD_EXCHANGE) Exchange deadExchange ){
        return BindingBuilder.bind(deadQueue).to(deadExchange).with("msg.dead").noargs();
    }



}
