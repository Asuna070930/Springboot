package com.atguigu.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) throws Exception {
        // 客户端需要连接RabbitMQ服务器，类似mysql客户端，连接mysql服务器
        // 设置数据源
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置主机
        connectionFactory.setHost("localhost");
        // 设置端口
        // 15672 : 表示后端插件网站的端口
        // 5672 ：表示RabbitMQ服务器端口
        connectionFactory.setPort(5672);
        // 设置用户名
        connectionFactory.setUsername("guest");
        // 设置密码
        connectionFactory.setPassword("guest");
        // 为了避免消息错误，需要设置虚拟主机
        connectionFactory.setVirtualHost("/");
        // 从工厂对象，获取连接对象
        Connection connection = connectionFactory.newConnection();
        // 默认情况下，系统使用的是TCP/IP协议，点对点，为了提高性能，底层开启了多线程
        // 在connection对象里面开启子线程，需要有多个频道对象
        Channel channel = connection.createChannel();
        // 创建（声明）一个队列
//        String queue, : 表示队列的名称
//        boolean durable, ：如果为true，队列需要进行持久化操作
//        boolean exclusive, 如果为true，我们会独占这个队列，这个地方都会设置为false，不会独占连接
//        boolean autoDelete, ：表示自动删除,如果队列不用是否需要自动删除
//        Map<String, Object> arguments 是否需要携带参数
        channel.queueDeclare("work_queue", true, false, false, null);
        // 客户端需要跟服务器发送消息
//        String exchange, ：表示交换机
//        String routingKey,表示路由规则
//        AMQP.BasicProperties props, ：表示属性
//        byte[] body ：表示消息体
        // 我们写的是入门案例，不使用交换机，系统默认会给我们提供一个交换机
        // 第一个参数：表示交换机的名字
        // 第二个参数：表示路由的规则
        // 第三个参数：表示发送消息的时候，是否需要携带属性
        // 第四个参数：表示消息体

        //模拟当前有很多人下单
        for (int i = 0; i < 10; i++) {
            String message = "下订单，订单id=1" + i;
            channel.basicPublish("", "work_queue", null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
