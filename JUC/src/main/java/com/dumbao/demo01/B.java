package com.dumbao.demo01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JUC版的生产者消费者
 */
public class B{

    public static void main(String[] args) {
        Data2 data = new Data2();
        //线程A +1操作
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        //线程B -1操作
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        //线程C +1操作
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
        //线程D -1操作
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D").start();
    }
}

//口诀：判断等待，业务，通知
class Data2 {
    private int number = 0;

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    //+1
    public  void increment() throws InterruptedException {
        try {
            lock.lock();
            //业务
            while (number != 0) {
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + " => " + number);
            //通知其他线程我+1完毕了
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //-1
    public  void decrement() throws InterruptedException {
        try {
            lock.lock();
            //业务
            while (number == 0) {
                //等待；
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " => " + number);
            //通知其他线程我-1完成了
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}