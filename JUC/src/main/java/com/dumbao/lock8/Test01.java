package com.dumbao.lock8;

import java.util.concurrent.TimeUnit;

public class Test01 {

    /**
     * //1.先发短信，还是先打电话：答案：先发短信，原因锁定的是同一个对象phone
     * //2.发短信休眠4秒，先发短信，还是先打电话。答案：先发短信，原因锁定的是同一个对象phone
     * //3.两个手机，先发短信，还是先打电话。答案：先打电话。原因是锁定的不同的phone对象
     * 4.先打电话，还是先发短信，还是先说hello。答案：先说hello，原因：hello方法没有加锁。
     * @param args
     */

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.call();
        },"B").start();

        new Thread(()->{
            phone.hello();
        }).start();
    }
}

class Phone {
    /**
     * 发短信
     */
    public synchronized void sendSms() {
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

    public void hello(){
        System.out.println("hello!");
    }
}



