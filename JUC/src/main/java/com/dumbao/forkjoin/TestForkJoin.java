package com.dumbao.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
//        test2();
        test3();
    }

    //普通程序员
    public static void test1(){
        long startTime = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("sum="+sum+"花费"+(endTime-startTime));
        //sum=500000000500000000花费7432
    }


    //会用ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinDemo forkJoinTask = new ForkJoinDemo(1L, 10_0000_0000L);

        ForkJoinTask<Long> joinTask = forkJoinPool.submit(forkJoinTask);

        Long sum = joinTask.get();

        long endTime = System.currentTimeMillis();
        System.out.println("sum="+sum+"花费"+(endTime-startTime));
        //sum=500000000500000000花费5941
    }

    //会用并行流
    public static void test3(){
        long startTime = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(1L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long endTime = System.currentTimeMillis();
        System.out.println("sum="+sum+"花费"+(endTime-startTime));
        //sum=500000000500000000花费334
    }
}
