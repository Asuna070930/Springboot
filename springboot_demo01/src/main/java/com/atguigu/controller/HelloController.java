package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${server.port}")
    private String port;

    @Value("${city}")
    private String city;

    @RequestMapping
    public String index(){
        System.out.println(port);
        System.out.println(city);
        return "index";
    }
}
