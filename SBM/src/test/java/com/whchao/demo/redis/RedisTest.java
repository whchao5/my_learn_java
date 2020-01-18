package com.whchao.demo.redis;

import com.whchao.demo.entity.Girls;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("aaa", "111");

        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }


    @Test
    public void testObjRedis() {

        Girls girls = new Girls();
        girls.setAge(18);
        girls.setId(2);
        girls.setName("hali");

//        stringRedisTemplate.opsForValue().set("com.whc", girls);

        ValueOperations<String, Girls> operations = redisTemplate.opsForValue();
        operations.set("com.girls", girls);


        boolean exists = redisTemplate.hasKey("com.girls");

        System.out.println(operations.get("com.girls"));
        Assert.assertTrue(exists);
    }
}
