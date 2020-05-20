package com.dumbao.lock;

import java.util.concurrent.atomic.AtomicReference;
//自己写的自旋锁
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference();
    //加锁
    public void myLock(){
        System.out.println(Thread.currentThread().getName()+" myLock");
        while(!atomicReference.compareAndSet(null,Thread.currentThread())){

        }
    }
    //解锁
    public void myUnlock(){
        System.out.println(Thread.currentThread().getName() + " myUnlock");
        atomicReference.compareAndSet(Thread.currentThread(),null);
    }
}
