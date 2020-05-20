package com.dumbao.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//synchronized可重入锁
public class LockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sms();
        }, "A").start();
        new Thread(() -> {
            phone.sms();
        }, "B").start();

    }
}

class Phone {
    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + " SMS");
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + " CALL");

    }
}
