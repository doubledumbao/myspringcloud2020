package com.dumbao.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo1 {

    /**
     * new ThreadPoolExecutor.AbortPolicy() 银行满了，还有人进来，不处理这个人的，抛出异常 java.util.concurrent.RejectedExecutionException
     * new ThreadPoolExecutor.CallerRunsPolicy() 哪来的去哪里
     * new ThreadPoolExecutor.DiscardPolicy() 队列满了，丢掉任务，不会抛出异常
     * new ThreadPoolExecutor.DiscardOldestPolicy() 队列满了，尝试去和最早的竞争，也不会抛出异常
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 0; i < 9; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

}
