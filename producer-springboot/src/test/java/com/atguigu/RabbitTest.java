package com.atguigu;

import com.sun.scenario.effect.impl.prism.PrTexture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/8 17:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 定向消息
     */
    @Test
    public void demo03() throws Exception {
        String exchangeName = "atguigu.direct";
        String message = "发送一个定向消息";
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }


    /**
     * 广播模式
     */
    @Test
    public void demo02() throws Exception {
        String exchangeName = "atguigu.fanout";
        String message = "发送一条广播消息";
        rabbitTemplate.convertAndSend(exchangeName, "", "hello");
    }


    /**
     * 简单模式
     *
     * @throws Exception
     */
    @Test
    public void demo01() throws Exception {
        rabbitTemplate.convertAndSend("boot_queue", "saber");
    }
}
