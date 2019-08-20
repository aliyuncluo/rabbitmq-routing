package com.cluo.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luolei
 * @Date 2019/8/20 9:55
 * @Description
 */
@RestController
public class ConsumerController {

    private Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @RabbitListener(queues = {"one-queue"},containerFactory = "rabbitListenerContainerFactory")
    public void receiveMessage(String message){
       //处理消息
       logger.info("接收到的消息为"+message);
    }
}
