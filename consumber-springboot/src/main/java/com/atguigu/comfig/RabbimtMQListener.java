package com.atguigu.comfig;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/9 13:58
 */
@Component
public class RabbimtMQListener {
    /**
     * 创建队列和交换机最简单的方式
     * <p>
     * ①创建一个队列对昂
     * ②创建一个绑定对象
     * ③创建一个交换机对象
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "atguigu.direct", type = ExchangeTypes.DIRECT), key = {"red", "blue"}))
    public void listener1(String message) {
        System.out.println("saber:" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "atguigu.direct", type = ExchangeTypes.DIRECT), key = {"red", "yellow"}))
    public void listener2(String message) {
        System.out.println("asuna:" + message);
    }




    /**
     * 广播监听器
     */
    @RabbitListener(queues = "fanout.queue1")
    public void fanoutQueue1(String message) {
        System.out.println("huge:" + message);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void fanoutQueue2(String message) {
        System.out.println("liuyifei:" + message);
    }


    /**
     * 标记当前类是一个监听器,时时刻刻需要监听队列
     */
    @RabbitListener(queues = "boot_queue")
    public void listenerQueue(String message) {
        System.out.println(message);
    }
}
