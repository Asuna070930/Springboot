package com.atguigu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

/**
 * @Description:
 * @Author: LiHao
 * @Date: 2023/6/6 15:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    /**
     * redis的数据类型
     * ① string类型,存储的是简单的key - value
     * ② List类型,存储的是集合,有序,可以重复
     * ③ set类型,村塾的是集合,没有顺序,不可以重复
     * ④ HASH类型,存储的是对象,类似存储的是pojo
     * ⑤ ZSET类型,存储的是集合,可以存储分数,进行排序
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void demo04()throws Exception{
        HashOperations hashOperations = redisTemplate.opsForHash();
        Object o = hashOperations.get("user", "username");
        System.out.println(o);
    }

    @Test
    public void demo03()throws Exception{
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("user","username","liuyifei");
        hashOperations.put("user","password","huge");
        hashOperations.put("user","address","xianjian");
    }

    @Test
    public void demo02() throws Exception {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String name = (String) valueOperations.get("name");
        System.out.println(name);
    }

    @Test
    public void demo01() throws Exception {
        //表示string类型
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "liuyifei");
    }
}
