package com.dumbao.fun;

import java.util.function.Consumer;

/**
 * 消费型接口:有一个输入参数，无返回参数
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("hello world!");

        System.out.println("---------------");

        Consumer<String> consumer1 = (str) -> {
            System.out.println(str);
        };
        consumer1.accept("hello java!");

    }
}
