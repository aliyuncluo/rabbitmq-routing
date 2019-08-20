package com.cluo.rabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Author luolei
 * @Date 2019/8/20 9:18
 * @Description 消息发送到交换机确认机制
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback{

    private Logger logger = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);

    /**
    *@Description
    *@Author  luolei
    *@Date 2019/8/20 9:21
    *@Param  
    *@Return  
    *@Exception 
    *
    **/
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
       logger.info("MsgSendConfirmCallBack="+correlationData);
       if(ack){
           logger.info("消息消费成功!");
       }else{
           logger.info("消息消费失败:"+cause+"\n重新发送");
       }
    }
}
