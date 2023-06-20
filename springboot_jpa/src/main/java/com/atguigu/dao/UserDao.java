package com.atguigu.dao;

import com.atguigu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 14:08
 */

/**
 * JpaRepository<T,ID> : T 表示当前的dao,需要操作哪个实体 ,ID: 表示主键id的类型
 */
public interface UserDao extends JpaRepository<User,Integer> {

}
