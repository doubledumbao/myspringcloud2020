package com.dumbao.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {
    public static void main(String[] args) {

//        List<String> strings = Arrays.asList("1", "2", "3");
//        System.out.println(strings);
//        List<String> list = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            //ConcurrentModificationException异常
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(list);
//            }).start();
//        }

        /**
         * 解决方案：
         * 1.Vector
         * 2.Collections.synchronizedList
         * 3.CopyOnWriteArrayList
         */

        //Vector
//        List<String> list = new Vector<>();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 5));
//                System.out.println(Thread.currentThread().getName() + "==> " + list);
//            }, String.valueOf(i)).start();
//        }
        //2.Collections.synchronizedList
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 5));
//                System.out.println(Thread.currentThread().getName() + "==> " + list);
//            }, String.valueOf(i)).start();
//        }

        //3.CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + "==> " + list);
            }, String.valueOf(i)).start();
        }

    }
}
