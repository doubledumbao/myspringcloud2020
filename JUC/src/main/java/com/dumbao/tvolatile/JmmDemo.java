package com.dumbao.tvolatile;

import java.util.concurrent.TimeUnit;


/**
 * 主线程更新了num,无法通知线程A,程序无法终止
 */
public class JmmDemo {
    //加volatile可以保证可见性
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while(num == 0){

            }
        },"A").start();

        TimeUnit.SECONDS.sleep(2);
        num = 1;
        System.out.println("num = 1");
    }
}
