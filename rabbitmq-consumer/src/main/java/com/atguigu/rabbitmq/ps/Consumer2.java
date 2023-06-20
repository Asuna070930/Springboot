package com.atguigu.rabbitmq.ps;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/7 11:44
 */
public class Consumer2 {
    public static void main(String[] args) throws Exception {
        //创建一个连接数据源的对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        DefaultConsumer consumer = new DefaultConsumer(channel){
            /**
             *
             * @param consumerTag 消息的标识,类似消息id ,唯一标识符
             * @param envelope 获取到客户端发送过来的交换机的名称,队列名名称
             * @param properties 获取客户端发送过来的属性
             * @param body 消息体
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(consumerTag);
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
                System.out.println(properties);
                System.out.println(new String(body));
            }
        };
        //取风潮包裹
        //第一个参数: 表示队列名称
        //第二个参数 : 表示消息是否自动签收
        channel.basicConsume("test_fanout_queue2", true, consumer);
        //不能关闭消息,消费者需要时时刻刻盯着生产者
    }
}
