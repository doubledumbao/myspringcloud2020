package com.dumbao.add;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    /**
     * 可以理解为减法计数器
     * 值日生在班中所有学生都放学离开教室后，才关闭教室的门
     *
     * @param args
     */
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "离开了教室！");
                latch.countDown();
            }, String.valueOf(i)).start();
        }

        try {
            //等计数器归0
            latch.await();
            System.out.println("值日生关门！！！");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
