package com.atguigu.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Entity:表示当前是一个实体类
 * @Table(name = "user") : 这个实体类需要跟数据库里面的user表进行绑定
 * 绑定到一起的好处就是,操作实体类就是操作数据库里面的表
 * @Id : 表示主键id
 * @Column(name = "id") : user实体类里面的属性需要跟数据库表里面的列进行绑定
 * @GeneratedValue(strategy = GenerationType.IDENTITY) : 主键id自行自动增长, 只能用在mysql数据库
 * @GeneratedValue(strategy = GenerationType.SEQUENCE) : 主要用在Oracle 数据库
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
