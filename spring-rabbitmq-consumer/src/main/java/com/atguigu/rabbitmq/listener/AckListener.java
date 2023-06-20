package com.atguigu.rabbitmq.listener;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/8 11:25
 */

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import javax.swing.*;
import java.io.IOException;

/**
 * 手动签收 需要注意
 * ①需要在配置文件里配置 acknowledge="manual"
 * ② 需要实现 ChannelAwareMessageListener 接口
 * <p>
 * 开发的时候,有些消息非常重要,不允许自动签收消息,必须手动签收
 */
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(new String(message.getBody()));
            //获取消息属性的标记,这个标记是唯一标识符
            //根据订单id,查询订单商品
            //判断用户是否已经支付,如果用户已经支付,出库存
            //如果用户没有支付,判断商品在购物车的事件,是否超过30min,回滚库存
            int a = 2 / 0;
            //第一个参数 : 表示tag,唯一标识符
            //第二个参数 : 表示手动签收消息
            //手动签收消息
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            //拒绝签收消息,收到的包裹可能有问题
            //第三个参数,是否允许消息重新回到队列,如果为true,允许消息回到队列,如果为false,则不允许
            //不会到队列消息就会丢失
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
