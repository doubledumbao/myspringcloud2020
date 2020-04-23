package com.dumbao.lock8;

import java.util.concurrent.TimeUnit;

public class Test04 {

    /**
     * 8.先发短信，还是先打电话：答案：先打电话，原因锁定的是两个不同的对象。
     * @param args
     */

    public static void main(String[] args) {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(() -> {
            phone1.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        },"B").start();
    }
}

class Phone3 {
    /**
     * 发短信
     */
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "发短信！");
    }

    /**
     * 打电话
     */
    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "打电话！");
    }
}



