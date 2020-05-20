package com.dumbao.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用：CompletableFuture
 * 异步执行
 * 成功回调
 * 失败回调
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //无返回值的runAsync异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+" runAsync ");
//            /**
//             * 执行结果：
//             * 111111
//             * ForkJoinPool.commonPool-worker-1 runAsync
//             * 22222
//             */
//        });
//
//        System.out.println("111111");
//        completableFuture.get();//获取阻塞执行结果
//        System.out.println("22222");
        //有返回值的异步回调
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+" supplyAsync => Integer");
            int x = 10/0;
            return 200;
        });
        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t===>" + t);//正常的返回结果
            System.out.println("u===>" + u);//错误信息
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
            return 500;
        }).get());
    }
    /**
     * 成功的打印记录：
     * ForkJoinPool.commonPool-worker-1 supplyAsync => Integer
     * t===>200
     * u===>null
     * 200
     */

    /**
     * 失败的打印记录：
     * ForkJoinPool.commonPool-worker-1 supplyAsync => Integer
     * t===>null
     * u===>java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
     * java.lang.ArithmeticException: / by zero
     * 500
     */
}
