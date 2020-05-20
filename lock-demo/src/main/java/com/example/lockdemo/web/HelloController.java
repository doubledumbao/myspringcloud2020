package com.example.lockdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {
    private static final String STOCK_KEY = "stock_product_0";

    @Value(value = "${server.port}")
    private String port;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @GetMapping("/stock")
    public String stock() {
        String lockKey = "LockKey";
        String lockValue = UUID.randomUUID().toString().replace("-", "");
        Boolean lockRusult = redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue, 10, TimeUnit.SECONDS);


        try {
            if (!lockRusult) {
                return "LOCK ERROR";
            }
            Integer s = Integer.valueOf(redisTemplate.opsForValue().get(STOCK_KEY));
            if (s > 0) {
                int num = s - 1;
                System.out.println(port + ":" + num);
                redisTemplate.opsForValue().set(STOCK_KEY, String.valueOf(num));
            } else {
                System.out.println("库存不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisTemplate.delete(lockKey);
        }

        return port;
    }

}
