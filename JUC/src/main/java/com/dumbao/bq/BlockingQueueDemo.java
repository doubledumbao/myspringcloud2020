package com.dumbao.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //test01();
        //test02();
        //test03();
        test04();
    }

    /**
     * 抛出异常
     */
    public static void test01(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
        //java.lang.IllegalStateException: Queue full
        //queue.add("d");


        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //java.util.NoSuchElementException
        System.out.println("队首元素："+queue.element());
        //java.util.NoSuchElementException
        //System.out.println(queue.remove());
    }
    /**
     * 有返回值，不抛出异常
     */
    public static void test02(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        //返回false
        //System.out.println(queue.offer("d"));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //队首元素：null
        System.out.println("队首元素："+queue.peek());
        //返回null
        System.out.println(queue.poll());

    }
    /**
     * 阻塞等待
     */
    public static void test03() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        //阻塞等待
        //queue.put("d");
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        //阻塞等待
        //System.out.println(queue.take());
    }
    /**
     * 超时等待
     */
    public static void test04() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.offer("a",2, TimeUnit.SECONDS);
        queue.offer("b",2, TimeUnit.SECONDS);
        queue.offer("c",2, TimeUnit.SECONDS);
        //两秒钟后超时，退出阻塞
        queue.offer("d",2, TimeUnit.SECONDS);
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        ////两秒钟后超时，返回null
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
    }

}
