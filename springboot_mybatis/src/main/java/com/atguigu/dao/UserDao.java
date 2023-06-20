package com.atguigu.dao;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper:被标记为mybatis里面的一个接口,可以呗spring boot进行扫描
@Mapper
public interface UserDao {
    public List<User> findAll();
}
