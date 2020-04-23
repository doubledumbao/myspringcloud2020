package com.dumbao.add;

import java.util.concurrent.Semaphore;
        import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    /**
     * 抢车位，6辆车，3个车位
     *
     * @param args
     */
    public static void main(String[] args) {
        //3个车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                //获得
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "进入了车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "汽车" + String.valueOf(i)).start();
        }
    }
}