package com.atguigu;

import com.atguigu.service.SendMailService;
import com.atguigu.service.impl.SendMailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 18:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTest {
    @Autowired
    private SendMailService service;

    @Test
    public void demo01() throws Exception {
        service.sendMaill();
    }
}
