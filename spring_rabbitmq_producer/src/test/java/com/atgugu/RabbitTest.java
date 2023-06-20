package com.atgugu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileReader;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/7 18:52
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq.xml")
public class RabbitTest {
    //发送消息的模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void demo08() throws Exception {
        //1.发送订单消息。 将来是在订单系统中，下单成功后，发送消息
        rabbitTemplate.convertAndSend("order_exchange",
                "order.msg",
                "订单信息：id=1,time=2020年4月30日16:41:47");

        //2.打印倒计时10秒
        for (int i = 10; i > 0; i--) {
            System.out.println(i + "...");
            Thread.sleep(1000);
        }
    }


    @Test
    public void demo07() throws Exception {
        rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.haha", "胡歌刘亦菲");
    }


    @Test
    public void demo06() throws Exception {
        rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.abc", "10s");
    }


    @Test
    public void demo05() throws Exception {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm");
        }
    }


    /**
     * 发送消息,有2个地方会丢失消息
     * ①交换机名字写错,消息会丢失
     * ②交换机没有写错,但是在交换机进行转换的过程中,路由规则写错,队列也收不到消息
     * <p>
     * 系统给我们设置了两个回调函数
     * ①setConfirmCallback : 主要针对交换机,如果出错,知道什么原因
     * ②setReturnCallback : 主要针对的路由规则
     * <p>
     * 发送确认消息
     * ①开启确认模式 在配置文件里面,需要设置开启确认模式:publisher-confirms="true"
     * ②需要设置确认的回调函数
     * <p>
     * 发送回退消息
     * ①配置文件里开启回退模式 publisher-returns="true"
     * ②设置回退的回调函数
     * ③设置一个属性 rabbitTemplate.setMandatory(true);
     */
    @Test
    public void demo04() throws Exception {

        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println(message);
                System.out.println(replyCode);
                System.out.println(replyText);
                System.out.println(exchange);
                System.out.println(routingKey);
            }
        });

        //设置一个确认的回调函数
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    //如果ack为真,说明服务器已经收到了消息
                    System.out.println("收到消息");
                } else {
                    //如果ack为假,说明服务器没有收到消息
                    System.out.println("没有收到:" + cause);
                }
            }
        });

        //单纯的发送消息,对方是否收到消息,客户端不清楚
        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "定向消息");
        //发送消息,使用的是异步操作,消息还没来得及处理,系统就需要使用消息
        //休眠的目的是等一下,一般情况下,休眠可以不加,如果发送消息的时候,发现代码全部正确,程序还是报错,可添加
        Thread.sleep(100);
    }


    /**
     * 通配符模式
     */
    @Test
    public void demo03() throws Exception {
        rabbitTemplate.convertAndSend("spring_topic_exchange", "atguigu.bj", "发送到spring_topic_exchange交换机atguigu.bj的消息");
        rabbitTemplate.convertAndSend("spring_topic_exchange", "atguigu.bj.1", "发送到spring_topic_exchange交换机atguigu.bj.1的消息");
        rabbitTemplate.convertAndSend("spring_topic_exchange", "atguigu.bj.2", "发送到spring_topic_exchange交换机atguigu.bj.2的消息");
        rabbitTemplate.convertAndSend("spring_topic_exchange", "guigu.cn", "发送到spring_topic_exchange交换机guigu.cn的消息");
    }


    /**
     * 广播模式
     */
    @Test
    public void demo02() throws Exception {
        //第一个参数: 表示交换机的名称
        //第二个参数: 表示路由规则
        //第三个参数 : 表示消息体
        rabbitTemplate.convertAndSend("spring_fanout_exchange", "", "你好");
    }


    @Test
    public void demo01() throws Exception {
        //第一个参数 : 路由规则,如果路由规则和队列名称一直,直接发送邮件
        //第二个参数 : 表示消息体
        rabbitTemplate.convertAndSend("spring_queue", "hello");
    }
}
