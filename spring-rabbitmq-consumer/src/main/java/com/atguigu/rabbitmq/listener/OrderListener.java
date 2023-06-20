package com.atguigu.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;


@Component
public class OrderListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println(new String(message.getBody()));
        /**
         * 根据订单id,查询订单商品
         * if(用户是否已支付){
         *     如果用户已支付,什么都不做,直接签收消息
         * }else{
         *     混滚库存
         * }
         */
    }
}