package com.dumbao.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    private  static AtomicInteger num = new AtomicInteger(0);

    public  static void add(){
        num.getAndIncrement(); //CAS
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            /**
             * public static int activeCount()
             * 返回当前线程的thread group及其子组中活动线程数的估计。 递归地遍历当前线程的线程组中的所有子组。
             * 返回的值只是一个估计，因为线程数可能会在此方法遍历内部数据结构时动态更改，并且可能受某些系统线程的存在的影响。 此方法主要用于调试和监视。
             *
             * 结果
             * 对当前线程的线程组和任何其他线程组中当前线程的线程组作为祖先的活动线程数的估计
             */
            Thread.yield();
        }
        System.out.println("num = " + num);

    }
}
