package com.atguigu.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 20:50
 */
@Component
public class TaskController {
    /**
     * cron : 表达式 ,有7个值组合而成,每个值之间使用空格进行分割
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void myTask() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
