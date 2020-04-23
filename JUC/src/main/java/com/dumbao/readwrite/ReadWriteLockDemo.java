package com.dumbao.readwrite;

import java.util.HashMap;
        import java.util.Map;
        import java.util.concurrent.locks.ReadWriteLock;
        import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁） -次只能被一个线程占有
 * 共享锁（读锁） 多个线程可以同时占有
 *
 * ReadWriteLock
 * 读-读 可以共存
 * 读-写 不能共存
 * 写-写 不能共存
 */

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        //没有锁
//        MyCache myCache = new MyCache();
        //有锁的缓存
        MyReadRriteLockCache myCache = new MyReadRriteLockCache();
        //10个线程写数据
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",Thread.currentThread().getName());
            },"线程"+String.valueOf(temp)).start();
        }

        //10个线程读数据
        for (int i = 0; i < 10; i++) {
            final  int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(temp)).start();
        }
    }
}

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();

    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入数据开始");
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入数据OK");
    }
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取数据开始");
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取数据OK");
    }
}

/**
 * 带读写锁的缓存
 */
class MyReadRriteLockCache{
    private volatile Map<String,Object> map = new HashMap<>();

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"写入数据开始");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入数据OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取数据开始");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取数据OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
