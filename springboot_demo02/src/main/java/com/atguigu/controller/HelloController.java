package com.atguigu.controller;

import com.atguigu.config.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    //把DataSourceProperties添加到ioc容器,所以可以直接注入
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @RequestMapping
    public String index(){
        System.out.println(dataSourceProperties);
        return "index";
    }
}
