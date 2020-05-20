package com.dumbao.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

//带版本号AtomicStampedReference，解决ABA问题
public class ABADemo {

    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(1, 1);

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1 stamp:" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a2:"+atomicStampedReference.compareAndSet(1, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a2:"+atomicStampedReference.getReference()+",stamp:"+atomicStampedReference.getStamp());

            System.out.println("a3:"+atomicStampedReference.compareAndSet(2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a3:"+atomicStampedReference.getReference()+",stamp:"+atomicStampedReference.getStamp());
        }, "A").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1 stamp:"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b:"+atomicStampedReference.compareAndSet(1, 2, stamp, stamp + 1));
            System.out.println("b:"+atomicStampedReference.getReference()+",b stamp:"+atomicStampedReference.getStamp());
        }, "B").start();
    }

}
