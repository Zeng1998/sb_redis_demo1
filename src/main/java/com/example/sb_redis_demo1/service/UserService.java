package com.example.sb_redis_demo1.service;

import com.example.sb_redis_demo1.dao.UserDao;
import com.example.sb_redis_demo1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserDao userDao;

    public User findUserById(int id) {
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        User user;
        if (hasKey) {
            long start = System.currentTimeMillis();
            user = operations.get(key);
            long end = System.currentTimeMillis();
            System.out.println("查询redis花费时间:" + (end - start)+"ms");
        } else {
            long start = System.currentTimeMillis();
            user = userDao.findUserById(id);
            //写入redis缓存
            operations.set(key, user, 5, TimeUnit.HOURS);
            long end = System.currentTimeMillis();
            System.out.println("查询mysql花费时间:" + (end - start)+"ms");
        }
        return user;
    }
}
