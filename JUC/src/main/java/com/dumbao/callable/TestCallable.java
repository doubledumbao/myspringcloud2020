package com.dumbao.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TestCallable {

    public static void main(String[] args) {
        MyCallable callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask,"A").start();//结果会被缓存
        new Thread(futureTask,"B").start();
        try {
            Integer integer = futureTask.get();//可能可能会等待，会阻塞
            System.out.println(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
