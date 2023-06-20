package com.atguigu.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/7 21:08
 */
public class fanoutQueueListener1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
