package com.atguigu.comfig;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.rabbit.core.RabbitAdmin.QUEUE_NAME;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/9 13:59
 */
@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "boot_queue";

    /**
     * 配置文件创建队列:
     * <rabbit:queue name="队列名称"></rabbit:queue>
     * 创建一个队列
     */
    @Bean
    public Queue queue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }
}
