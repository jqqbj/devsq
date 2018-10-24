package com.jdb.demo.helper;


import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

@Component
public class RedisHelper {

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    public void set(String key, Serializable value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
