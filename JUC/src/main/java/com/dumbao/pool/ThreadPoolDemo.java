package com.dumbao.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一个线程
//       ExecutorService threadPool =  Executors.newFixedThreadPool(5);//固定线程池容量
//        ExecutorService threadPool = Executors.newCachedThreadPool();// 可伸缩容量,遇强则强

        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
