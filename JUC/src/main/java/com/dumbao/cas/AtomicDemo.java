package com.dumbao.cas;

import java.util.concurrent.atomic.AtomicInteger;
//ABA问题
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);


        //捣乱的线程开始
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());
        //捣乱的线程结束

        //期望的线程
        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());

        /**
         * 执行结果：
         * true
         * 2021
         * true
         * 2020
         * true
         * 6666
         */
    }
}
