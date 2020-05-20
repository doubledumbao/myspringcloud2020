package com.example.springbootdemo.lock;

import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestLock {

    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = new Jedis("192.168.0.101", 6379);
        String lockKey = "lock:product:0001";
        String requestId = UUID.randomUUID().toString().replace("-","");
        boolean b = RedisTool.tryGetDistributedLock(jedis, lockKey, requestId, 60000);
        System.out.println("获取锁结果:"+b);

        TimeUnit.SECONDS.sleep(3);

        boolean b1 = RedisTool.releaseDistributedLock(jedis, lockKey, requestId+1);
        System.out.println("释放锁结果："+b1);

    }
}
