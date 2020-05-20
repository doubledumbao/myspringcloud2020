package com.dumbao.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock 可重入锁
public class LockDemo1 {
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

class Phone1 {
    private final Lock lock = new ReentrantLock();
    //发短信
    public void sms() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " SMS");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //打电话
    public void call() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " CALL");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
