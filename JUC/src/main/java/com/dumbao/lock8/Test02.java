package com.dumbao.lock8;

import java.util.concurrent.TimeUnit;

public class Test02 {

    /**
     * //5.先发短信，还是先打电话：答案：先发短信，原因锁定的是同一个Phone.class对象
     * 6.先发短信，还是先打电话：答案：先发短信，原因锁定的是同一个Phone.class对象
     * @param args
     */

    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();
        Phone1 phone2 = new Phone1();

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

class Phone1 {
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
    public static synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "打电话！");
    }
}



