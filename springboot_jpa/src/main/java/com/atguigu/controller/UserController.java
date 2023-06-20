package com.atguigu.controller;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 14:22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.findUsers();
    }

    @RequestMapping("/save")
    public String save(){
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("123");
        user.setUsername("zhangsan");
        userService.saveUser(user);
        return "success";
    }

    @RequestMapping("/update")
    public String update(){
        User user = new User();
        user.setId(1);
        user.setName("wangwu");
        user.setPassword("123");
        user.setUsername("王五");
        userService.saveUser(user);
        return "success";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "success";
    }
}
