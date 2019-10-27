package com.whchao.xmall.service.impl;

import com.whchao.xmall.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis操作Service,
     * 对象和数组都以json形式进行存储
     * Created by macro on 2018/8/7.
     */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取数据
     */
    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }


    /**
     * 设置超期时间
     */
    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }


    /**
     * 删除数据
     */
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }


    /**
     * 自增长
     */
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
