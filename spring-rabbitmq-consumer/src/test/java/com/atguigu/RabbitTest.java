package com.atguigu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/7 20:11
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq.xml")
public class RabbitTest {

    @Test
    public void demo01() throws Exception{
        while (true){

        }
    }
}
