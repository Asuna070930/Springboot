package com.atguigu;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 8:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordTest {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void demo01() throws Exception{
        String username = stringEncryptor.encrypt("root");
        String password = stringEncryptor.encrypt("root");
        String url = stringEncryptor.encrypt("jdbc:mysql://127.0.0.1:3306/springboot?serverTimezone=Asia/Shanghai");
        System.out.println(username);
        System.out.println(password);
        System.out.println(url);
    }
}
