package com.example.springbootdemo.lock;

import java.util.concurrent.*;

public class ThreadPoolDemo {




    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(5,
                5,
                60L,
                TimeUnit.SECONDS,
                new PriorityBlockingQueue(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

//        Thread thread = new Thread(new T1(3));
//        threadPoolExecutor.submit(thread);
//        Thread thread1 = new Thread(new T2(9));
//        threadPoolExecutor.submit(thread1);


        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(()->{
                new T1(3).print();
            });
            threadPoolExecutor.execute(()->{
                new T2(9).print();
            });
        }

    }


}


class T {
    protected int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }




}

class T1 extends T implements Comparable<T>{
    public T1(){}

    public T1(int priority){
        super.priority = priority;
    }

    public void print(){
        System.out.println(Thread.currentThread().getName()+"  print T1");
    }

    @Override
    public int compareTo(T o) {
        return this.priority - o.priority;
    }


}

class T2 extends T implements Comparable<T>{
    public T2(){}

    public T2(int priority){
        super.priority = priority;
    }

    public void print(){
        System.out.println(Thread.currentThread().getName()+"  print T2");
    }

    @Override
    public int compareTo(T o) {
        return this.priority - o.priority;
    }

}

