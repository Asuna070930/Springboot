package com.atguigu.service;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 14:12
 */
public interface UserService {
    List<User> findUsers();

    User findUserById(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
