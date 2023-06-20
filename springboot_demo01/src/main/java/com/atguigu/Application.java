package com.atguigu;

import com.atguigu.poji.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication  //标记当前项目是一个spring boot工程
public class Application {
    //入口方法
    public static void main(String[] args) {
        //启动程序,获取哦spring的容器
        ApplicationContext context = SpringApplication.run(Application.class, args);
        //从武器当中获取到bean对象
        User user = (User) context.getBean("user");
        System.out.println(user);
//        for (String bean : context.getBeanDefinitionNames()) {
//            System.out.println(bean);
//        }
    }
}
