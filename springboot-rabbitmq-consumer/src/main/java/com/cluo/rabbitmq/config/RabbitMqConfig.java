package com.cluo.rabbitmq.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*@Author luolei
*@Date  2019/8/20 9:43
*@Description  RabbitMq配置 用于将消息队列与消息交换机进行绑定
*/
@Configuration
public class RabbitMqConfig {

        /** 队列key1*/
       public static final String ROUTINGKEY1 = "user";
       public static final String ROUTINGKEY2 = "role";

        @Autowired
        private QueueConfig queueConfig;
        @Autowired
        private ExchangeConfig exchangeConfig;
        /**
         * 连接工厂
         */
        @Autowired
        private ConnectionFactory connectionFactory;

        /**
         将消息队列和交换机进行绑定并关联routingKey
         */
        @Bean
        public Binding bindingExchange1() {
                return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY1);
        }

        @Bean
        public Binding bindingExchange2() {
                return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY2);
        }


        /**
         * 消息确认机制
         * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
         * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
         * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
         * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
         * @return
         */
        @Bean
        public MsgSendConfirmCallBack msgSendConfirmCallBack(){
            return new MsgSendConfirmCallBack();
        }

}



