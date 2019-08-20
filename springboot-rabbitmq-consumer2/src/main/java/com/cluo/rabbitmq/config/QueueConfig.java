package com.cluo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author luolei
 * @Date 2019/8/20 11:26
 * @Description
 */
@Configuration
public class QueueConfig {

    public static final String QUEUE_NAME = "two-queue";

    @Bean
    public Queue secondQueue(){
        return new Queue(QUEUE_NAME,true,false,false);
    }
}
