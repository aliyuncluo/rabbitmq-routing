package com.cluo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author luolei
 * @Date 2019/8/20 9:10
 * @Description  队列配置  可以配置多个队列
 */

@Configuration
public class QueueConfig {

    public static final String QUEUE_NAME="one-queue";

    @Bean
    public Queue firstQueue(){
        /**
         durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         */
        return new Queue(QUEUE_NAME,true,false,false);
    }

}
