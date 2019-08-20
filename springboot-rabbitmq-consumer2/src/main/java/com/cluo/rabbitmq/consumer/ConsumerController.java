package com.cluo.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luolei
 * @Date 2019/8/20 10:52
 * @Description
 */
@Controller
public class ConsumerController {

    private Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @RabbitListener(queues = {"two-queue"},containerFactory = "rabbitListenerContainerFactory")
    public void receiveMessage(String message){
        logger.info("接收到的消息为："+message);
    }
}
