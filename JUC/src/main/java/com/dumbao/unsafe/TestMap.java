package com.dumbao.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {

    public static void main(String[] args) {
//        Map<String,String> map = new HashMap<>();
//        //ConcurrentModificationException
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
//                System.out.println(map);
//            },String.valueOf(i)).start();
//        }

        /**
         * 解决方案：
         * 1.
         * 2.
         */
//        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
//        //ConcurrentModificationException
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
//                System.out.println(map);
//            },String.valueOf(i)).start();
//        }
        Map<String,String> map = new ConcurrentHashMap<>();
        //ConcurrentModificationException
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
