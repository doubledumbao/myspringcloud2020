package com.dumbao.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//懒汉模式
public class LazyMan {

    private LazyMan(){
        synchronized (LazyMan.class){
            if(lazyMan != null){
                throw new RuntimeException("禁止通过反射破坏单例模式");
            }
        }
    }

    private static volatile LazyMan lazyMan ;

    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized(LazyMan.class){
                if(lazyMan == null){
                    /**
                     * 不是原子性操作：
                     * 1.分配内存空间
                     * 2.执行构造函数，初始化对象
                     * 3.将这个对象指向该空间
                     */
                    lazyMan = new LazyMan();

                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                LazyMan lazyMan = LazyMan.getInstance();
//                System.out.println(lazyMan);
//            }).start();
//        }
        //通过反射破坏单例模式
//        LazyMan lm = LazyMan.getInstance();
//        System.out.println(lm);
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan1 = declaredConstructor.newInstance(null);
        LazyMan lazyMan2 = declaredConstructor.newInstance(null);
        LazyMan lazyMan3 = declaredConstructor.newInstance(null);
        System.out.println(lazyMan1);
        System.out.println(lazyMan2);
        System.out.println(lazyMan3);
    }


}
