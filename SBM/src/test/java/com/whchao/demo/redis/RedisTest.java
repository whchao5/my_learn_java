package com.whchao.demo.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {



    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("aaa", "111");

        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
}
