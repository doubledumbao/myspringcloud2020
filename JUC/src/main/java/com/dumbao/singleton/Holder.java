package com.dumbao.singleton;

import java.lang.reflect.Constructor;

/**
 * 静态内部类
 */
public class Holder {
    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        public static Holder HOLDER = new Holder();
    }

    public static void main(String[] args) throws Exception {
        Holder holder1 = Holder.getInstance();
        Holder holder2 = Holder.getInstance();
        System.out.println(holder1);
        System.out.println(holder2);
        //通过反射破坏单例模式
        Constructor<Holder> declaredConstructor = Holder.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Holder holder3 = declaredConstructor.newInstance(null);
        Holder holder4 = declaredConstructor.newInstance(null);
        System.out.println(holder3);
        System.out.println(holder4);

    }
}
